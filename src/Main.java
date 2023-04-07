import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import jaco.mp3.player.MP3Player;
import java.io.File;

public class Main {

    public static double randomInt (int min, int max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
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

        // Listando as câmaras
        //cave.listChambers();

        //System.out.println(cave.findEscape(chamber1));

        //clear screen
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        //Game name art
        System.out.println("\n-__ /\\\\                              ,          ,- _~.                  \n" +
                "  ||  \\\\              '             ||         (' /|     _   ;          \n" +
                " /||__|| ,._-_  /'\\\\ \\\\  _-_   _-_ =||=       ((  ||    < \\, \\\\/\\  _-_  \n" +
                " \\||__||  ||   || || || || \\\\ ||    ||        ((  ||    /-|| || | || \\\\ \n" +
                "  ||  |,  ||   || || || ||/   ||    ||         ( / |   (( || || | ||/   \n" +
                "_-||-_/   \\\\,  \\\\,/  || \\\\,/  \\\\,/  \\\\,         -____-  \\/\\\\ \\\\/  \\\\,/  \n" +
                "  ||                 |;                                                 \n" +
                "                     /                                                  ");

        //sound
        Scanner a = new Scanner(System.in);
        System.out.print("\nEnable audio (Y/N): ");
        String choice = a.nextLine();
        if(choice.equals("y") || choice.equals("Y")) {
            try {
                File f = new File("files/Dowland_-_Melancholy_Galliard.mp3");
                MP3Player mp3Player = new MP3Player(f);
                Thread newThread = new Thread(() -> {
                    mp3Player.play();
                    File f2 = new File("files/Michael_Christian_Durrant_Classical_Guitar_Erik Satie_Gymnopedie_no_1_arr_Mermikides.mp3");
                    mp3Player.addToPlayList(f2);
                    mp3Player.play();
                });
                newThread.start();
                while (!mp3Player.isStopped()) {
                    Thread.sleep(5000);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        //variables of the game and player
        System.out.print("\nWrite the name of your character: ");
        String name = a.nextLine();
        Player player = new Player(name, chamber1, 1000);
        Text text = new Text();

        System.out.println("Write 'quit game' at any momento to quit the game!");

        //texts
        text.addStartText("\nAs you stir from your slumber, you find yourself in a desolate and frigid chamber. With naught but a flickering torch to guide you, you rise to your feet, the scant light illuminating the bleak surroundings. A palpable sense of danger fills the air, and you can hear the faint drip of water echoing off the walls. It seems you have stumbled upon a treacherous cave.");
        text.addStartText("\nYou sprinted through the dense forest, the sound of leaves crunching beneath your feet echoing around you. Suddenly, you fall into a deep hole, and everything fades to black. When you open your eyes, you're lying on the cold, hard ground, and the moonlight streaming down from the hole above is the only source of light. As you try to gather your bearings, you notice a flickering torch next to you, casting eerie shadows on the damp earth.");
        text.addStartText("\nA mysterious cave entrance looms before you, beckoning you with an otherworldly allure. Your curiosity piqued, you take the first steps inside. Suddenly, with a deafening rumble, the entrance collapses behind you, trapping you inside. Panic begins to set in, but as you fumble through your belongings, you find a flickering torch to guide your way.");
        text.addStartText("\nFollowing a night of revelry at the local tavern, you decide to make your way home and collapse into your bed. Exhaustion overcomes you, and you drift off into a deep slumber. However, when you awaken, the sound of dripping water echoes in your ears, and you realize that your bed has disappeared. You're lying on the hard ground, and the only light comes from a solitary torch by your side. As you look around, you see that you're in a cavernous chamber, with towering rock walls stretching up into the darkness above. You're alone in this strange and unknown place, with only your trusty torch to guide you.");
        text.addStartText("\nThe village where you grew up has been overrun by an army of enemies. In a desperate attempt to escape, you run deep into the forest, clutching a flickering torch in your hand. As the sounds of battle fade into the distance, you stumble upon a small cave entrance hidden among the trees. Driven by fear and instinct, you venture deeper and deeper into the cavern, feeling safer with every step. You hear strange noises outside the cave, but eventually, exhaustion overtakes you, and you fall into a deep slumber. When you awaken, you're disoriented and alone, trapped in a place you don't recognize. Your torch has burned low, but it's enough to cast an eerie glow on the rough-hewn walls of the cave. You must find a way out, but you're unsure where to start. You take a deep breath, steel yourself for whatever may come.");

        System.out.println(text.getStartText((int) randomInt(0, text.getStartTextLenght())));

        //game start
        String choice2;
        String choice3;
        //need a reasonable condition
        while(true){
           ascChamber();
           System.out.print("(1) Check the chamber around you\n(2) Check if there is any other paths you can go\n(3) Check yourself\nWhat will you do? ");
           choice = a.nextLine();
           switch(choice){
               case "1":
                   handleCheckCurrentChamber();
                   break;
               case "2":
                   System.out.println("There are "+ player.getLocation().getConnections().size() +" paths surrounding you.");
                   System.out.print("(1) Check where one of these paths seems to led to\n(2) Choose path to follow\nWhat will you so? ");
                   choice2 = a.nextLine();
                   switch (choice2) {
                       case "1":
                           boolean check = false;
                           while (check == false) {
                               System.out.print("What path do you want to check(number between 1 and" + player.getLocation().getConnections().size() + "):\n");
                               choice3 = a.nextLine();
                               if (Integer.parseInt(choice3) > 1 && Integer.parseInt(choice3) <= player.getLocation().getConnections().size()){
                                    handleCheckSelectedChamber(player.getLocation();
                               }
                           }
                           break;
                       case "2":
                           break;
                       default:
                           break;
                   }
                   break;
               case "3":
                   handlePlayerCheck();
                   break;
               case "quit game":
                   handleQuitGame();
                   break;
               default:
                   break;
           }
        }
    }
}
