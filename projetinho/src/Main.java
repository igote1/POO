import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ranking ranking = new Ranking();
        ranking.exibirRanking();

        while (true) {
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            Player player = new Player(nome);
            Game game = new Game();

            while (true) {
                System.out.print(nome + ", digite o valor da sua aposta (entre 1 e 12): ");
                int aposta = scanner.nextInt();
                scanner.nextLine(); 

                if (game.adicionarAposta(player, aposta)) {
                    break;
                }
            }

            int soma = game.sortearDados();
            Player vencedor = game.verificarVencedor(soma);

            if (vencedor != null) {
                ranking.atualizarRanking(vencedor);
            }

            System.out.print("Deseja continuar jogando? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }

        scanner.close();
    }
}
