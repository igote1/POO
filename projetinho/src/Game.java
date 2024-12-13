import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<Integer, Player> apostas;  
    private Dado dado1;
    private Dado dado2;

    public Game() {
        this.apostas = new HashMap<>();
        this.dado1 = new Dado();
        this.dado2 = new Dado();
    }

    public boolean adicionarAposta(Player player, int valor) {
        if (valor < 1 || valor > 12) {
            System.out.println("Valor de aposta inválido! Deve ser entre 1 e 12.");
            return false;
        }
        if (apostas.containsKey(valor)) {
            System.out.println("O número " + valor + " já foi apostado!");
            return false;
        }
        apostas.put(valor, player);
        return true;
    }

    public int sortearDados() {
        int soma = dado1.sortear() + dado2.sortear();
        System.out.println("Número sorteado: " + soma);
        return soma;
    }

    public Player verificarVencedor(int soma) {
        if (apostas.containsKey(soma)) {
            Player vencedor = apostas.get(soma);
            System.out.println(vencedor.getNome() + " venceu!");
            vencedor.registrarVitoria();
            return vencedor;
        } else {
            System.out.println("Máquina venceu!");
            return null;
        }
    }
}
