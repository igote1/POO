public class Player {
    private String nome;
    private int vitorias;

    public Player(String nome) {
        this.nome = nome;
        this.vitorias = 0;
    }

    public void registrarVitoria() {
        this.vitorias++;
    }

    public int getVitorias() {
        return vitorias;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + ": " + vitorias + " vitórias";
    }
}
