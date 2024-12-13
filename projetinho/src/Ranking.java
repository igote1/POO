import java.io.*;
import java.util.*;

public class Ranking {
    private List<Player> players;

    public Ranking() {
        this.players = new ArrayList<>();
        carregarRanking();
    }

    public void carregarRanking() {
        try {
            File file = new File("ranking.txt");
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String nome = parts[0];
                    int vitorias = Integer.parseInt(parts[1]);
                    Player player = new Player(nome);
                    for (int i = 0; i < vitorias; i++) {
                        player.registrarVitoria();
                    }
                    players.add(player);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(players, (p1, p2) -> Integer.compare(p2.getVitorias(), p1.getVitorias()));
    }

    public void atualizarRanking(Player player) {
        carregarRanking();
        boolean found = false;
        for (Player p : players) {
            if (p.getNome().equals(player.getNome())) {
                p.registrarVitoria();
                found = true;
                break;
            }
        }
        if (!found) {
            players.add(player);
        }
        Collections.sort(players, (p1, p2) -> Integer.compare(p2.getVitorias(), p1.getVitorias()));
        salvarRanking();
    }

    private void salvarRanking() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("ranking.txt"));
            for (int i = 0; i < Math.min(5, players.size()); i++) {
                Player p = players.get(i);
                writer.write(p.getNome() + "," + p.getVitorias());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibirRanking() {
        System.out.println("TOP 5 Jogadores:");
        for (int i = 0; i < Math.min(5, players.size()); i++) {
            System.out.println(players.get(i));
        }
    }
}
