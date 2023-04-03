import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Criando as câmaras
        Chamber chamber1 = new Chamber(0, "Câmara 1", "Conteúdo da Câmara 1", false, new ArrayList<>());
        Chamber chamber2 = new Chamber(15, "Câmara 2", "Conteúdo da Câmara 2", false, new ArrayList<>());
        Chamber chamber3 = new Chamber(20, "Câmara 3", "Conteúdo da Câmara 3", false, new ArrayList<>());
        Chamber chamber4 = new Chamber(40, "Câmara 4", "Conteúdo da Câmara 4", false, new ArrayList<>());
        Chamber chamber5 = new Chamber(27, "Câmara 5", "Conteúdo da Câmara 5", true, new ArrayList<>());

        // Criando o túnel
        Tunnel tunnel1 = new Tunnel(chamber1, chamber2, 20);
        Tunnel tunnel2 = new Tunnel(chamber1, chamber3, 21);
        Tunnel tunnel3 = new Tunnel(chamber2, chamber4, 22);
        Tunnel tunnel4 = new Tunnel(chamber4, chamber5, 23);
        Tunnel tunnel5 = new Tunnel(chamber3, chamber5, 24);

        // Criando a caverna
        List<Chamber> chambers = new ArrayList<>();
        chambers.add(chamber1);
        chambers.add(chamber2);
        chambers.add(chamber3);
        chambers.add(chamber4);
        chambers.add(chamber5);

        Cave cave = new Cave(chambers);

        // Conectando as câmaras
        cave.connectChambers(tunnel1);
        cave.connectChambers(tunnel2);
        cave.connectChambers(tunnel3);
        cave.connectChambers(tunnel4);
        //cave.connectChambers(tunnel5);

        cave.listChambers();

        System.out.println(cave.findEscape(chamber1));

        // Listando as câmaras
        //cave.listChambers();
    }
}
