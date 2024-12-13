import java.util.Random;

public class Dado {
    private int valor;

    public Dado() {
        this.valor = 0;
    }

    public int sortear() {
        Random rand = new Random();
        this.valor = rand.nextInt(6) + 1;
        return this.valor;
    }
}
