import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Criando as câmaras
        Chamber chamber1 = new Chamber(1, "Câmara 1", "Conteúdo da Câmara 1", false, new ArrayList<>());
        Chamber chamber2 = new Chamber(1, "Câmara 2", "Conteúdo da Câmara 2", false, new ArrayList<>());
        Chamber chamber3 = new Chamber(2, "Câmara 3", "Conteúdo da Câmara 3", false, new ArrayList<>());
        Chamber chamber4 = new Chamber(3, "Câmara 4", "Conteúdo da Câmara 4", false, new ArrayList<>());

        // Criando o túnel
        Tunnel tunnel1 = new Tunnel(chamber1, chamber2, 10);

        // Criando a caverna
        List<Chamber> chambers = new ArrayList<>();
        chambers.add(chamber1);
        chambers.add(chamber2);
        chambers.add(chamber3);
        chambers.add(chamber4);

        Cave cave = new Cave(chambers);

        // Conectando as câmaras
        cave.connectChambers(tunnel1);

        // Listando as câmaras
        cave.listChambers();
    }
}
