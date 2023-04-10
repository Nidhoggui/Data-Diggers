import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import jaco.mp3.player.MP3Player;
import org.fusesource.jansi.AnsiConsole;
import java.io.File;

public class Main {

    public static double randomInt (int min, int max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

    //arts
    public static void ascChamber(Player player, Cave cave) {
        int chamberIndex = cave.getChambers().indexOf(player.getLocation());

        if (chamberIndex % 3 == 0) {
            System.out.println( "\n ░░▒▒▒▒▒▒░░░░▒▒░░▒▒░░░░░░▓▓░░▒▒░░░░░░░░░░░░░░▒▒░░░░░░▒▒░░░░▒▒░░░░░░▒▒▒▒░░░░░\n" +
                    " ░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░▒▒░░░░░░░░░░░░▒▒░░▒▒▒▒░░░▒▒▒▓▓▓▓▒\n" +
                    " ░░▒▒░░▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒░░▒▒░░░░░░░░▒▒▒▒░░░░▒▒▒▒░░▒▒▒▒▒▒░░░\n" +
                    " ▒▒▒▒░░░░░░░░▒▒▒▒░░▒▒▒▒▒▒▒▒░░░░░░░░▒▒░░▓▓▒▒░░░░░░▒▒▒▒▒▒▒▒░░░░▒▒░░▒▒▒▒▓▓▒▒░░░\n" +
                    " ▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▓▓▓▓▒▒▒▒  ░░░░  ░░░░  ▒▒▒▒▒▒▒▒░░    ▒▒░░░░▒▒░░░░░░▒\n" +
                    " ▒▒▒▒░░▒▒░░▒▒░░░░░░░░  ░░░░░░░░    ░░▒▒░░░░░░                ░░  ░░        ░\n" +
                    " ▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▓▓▓▓▒▒░░                        ░\n" +
                    " ░░▒▒▒▒▒▒  ░░░░  ░░░░░░░░░░░░░░░░░░▒▒▒▒▓▓██████▓▓▓▓▒▒        ░░  ░░░░      ▒\n" +
                    " ░░░░    ░░░░░░░░░░░░░░░░░░░░░░▒▒████████▓▓██▓▓▓▓██▓▓▓▓        ░░░░░░░░  ░░ \n" +
                    " ░░▒▒  ░░░░  ░░░░░░░░░░░░░░▒▒██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░  ░░░░    ░░   \n" +
                    "   ░░▒▒  ░░  ░░░░░░░░░░▒▒██████████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓██░░  ░░    ░░░░░\n" +
                    " ░░░░    ░░░░░░░░░░▒▒▒▒██████████████▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓██▓▓░░        ░░░\n" +
                    " ░░░░  ░░░░░░░░▒▒▒▒▒▒▓▓██████▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓░░        ░\n" +
                    "   ░░░░░░▒▒░░▒▒▒▒▒▒▓▓████████▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓████▓▓▒▒░░      ░\n" +
                    " ░░░░░░▒▒▒▒░░▒▒▒▒▒▒██████████▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓████▓▓██░░      ░\n" +
                    " ▒▒░░░░▒▒░░░░▒▒▒▒▓▓▓▓▓▓████▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓██▓▓████▓▓██░░░░    ░\n" +
                    " ░░▒▒▒▒▒▒▒▒░░▒▒▒▒██▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓██████▓▓▓▓██      ░\n" +
                    " ▒▒▒▒▒▒░░░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▒▒▓▓▓▓▓▓████▓▓▓▓██      ░\n" +
                    " ▒▒▒▒▒▒░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▓▓██████▓▓▓▓██░░    ░\n" +
                    " ▒▒▒▒▓▓▒▒▒▒▒▒▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▒▒▒▒▓▓▓▓▓▓████▓▓████       \n" +
                    " ▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▒▒▒▒▓▓▓▓██████▓▓██▓▓     \n" +
                    " ▒▒▒▒▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓██▓▓██████▓▓▓▓██  ░░ \n" +
                    " ▒▒▒▒████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▒▒▓▓▒▒▓▓▒▒▓▓▓▓▓▓██████▓▓▓▓██░░▒▒ \n" +
                    " ▒▒▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓████████████▒▒▒▒ \n" +
                    " ▒▒██▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓▒▒▓▓▓▓██████████████▓▓ \n" +
                    " ▓▓▓▓██████████████████████████████████████████████▓▓▓▓▓▓▓▓▓▓██████████████ \n" +
                    " ██████████████████████████████████████████████████████████████████████████ \n" +
                    " ▓▓████▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░\n" +
                    " ▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒\n");
        }
        if (chamberIndex % 3 == 1) {
            System.out.println("\n ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n" +
                    " ▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n" +
                    " ▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n" +
                    " ▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓\n" +
                    " ▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒\n" +
                    " ▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒\n" +
                    " ▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                    " ▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒░░░░░░▒▒▒▒▒▒\n" +
                    " ░░░░▒▒▒▒▒▒░░▓▓░░░░░░▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒░░░░░░░░▒▒░░\n" +
                    " ░░░░▒▒▒▒▒▒░░▓▓░░░░░░░░░░▓▓▓▓▓▓▒▒░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒░░░░░░░░▒▒▒▒░░░░░░░░░░░░░░\n" +
                    " ░░  ░░▒▒░░░░▒▒░░░░░░░░░░▓▓▓▓▓▓▒▒  ░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒░░░░░░░░░░░░░░\n" +
                    "     ░░▒▒    ▒▒        ░░▓▓▓▓▓▓░░░░░░    ░░  ▒▒▒▒▒▒░░    ░░░░░░░░░░░░░░░░░░░░░░░░  \n" +
                    "       ░░    ░░          ██▓▓▓▓  ░░░░        ░░▒▒▒▒      ░░░░          ░░    ░░░░  \n" +
                    "             ░░          ▓▓▓▓▓▓  ░░░░          ▒▒░░      ░░░░                      \n" +
                    "             ░░        ░░▓▓▓▓▓▓                ░░                                  \n" +
                    "       ░░  ░░░░        ▒▒▓▓▓▓▓▓░░  ░░          ▒▒        ░░                    ░░  \n" +
                    "     ▒▒▒▒░░▒▒▒▒░░      ▓▓▓▓▓▓▓▓▒▒░░░░        ░░▒▒░░        ░░                ░░░░░░\n" +
                    " ░░░░▒▒▒▒░░▓▓▒▒░░░░░░▒▒▓▓▓▓▓▓▓▓▓▓░░░░░░  ░░  ▒▒▒▒▒▒      ░░░░  ░░    ░░      ░░░░░░\n" +
                    " ▒▒▒▒▒▒▒▒▒▒▓▓▓▓░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓░░▒▒░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░░░▒▒░░  ░░░░░░░░░░░░░░\n" +
                    " ▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▒▒░░▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒░░▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒▒▒\n" +
                    " ▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                    " ▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                    " ▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▓▓▓▓\n" +
                    " ▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓\n" +
                    " ▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓\n" +
                    " ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓\n" +
                    " ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓\n" +
                    " ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓\n" +
                    " ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n" +
                    " ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n");
        }
        if (chamberIndex % 3 == 2) {
            System.out.println("\n ▓████████████▓▓▒▒██▓▓▒▒░░░░  ░░░░░░  ▒▒░░░░░░░░  ░░░░░░  ░░▓▓▓▓██████████████████\n" +
                                " ▓████████████████████████    ░░░░░░░░▒▒    ░░    ░░░░░░░░▓▓▓▓▓▓██████████████████\n" +
                                " ▒▓▓██████████████████████    ░░░░░░▒▒▒▒░░  ░░    ░░░░░░▓▓▓▓▓▓████████████████████\n" +
                                " ▒▓▓▓▓██▓▓████████████████    ░░▒▒▒▒▒▒▒▒░░░░░░    ░░░░▒▒▓▓▓▓▓▓████████████████████\n" +
                                " ░▒▒▒▒▓▓▓▓████████████████░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░    ░░▒▒████████████████████████████\n" +
                                "  ░░▒▒▓▓▓▓████████████████▒▒░░▒▒▒▒▒▒▒▒░░░░▒▒░░▒▒░░▒▒██████████████████████████████\n" +
                                "    ░░▓▓▓▓████████████████▒▒▒▒▓▓▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▓▓████████████████████████████████\n" +
                                "      ▒▒▓▓██████████████████████▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓██████████████████████████████▓▓\n" +
                                "      ░░▒▒▓▓██▓▓██████████▓▓████▓▓██████████████████████████████████████████████▓▓\n" +
                                "        ░░▓▓██▓▓████████████████████████████████████████████████████████████▒▒▓▓▓▓\n" +
                                "        ░░▒▒██▓▓██████████████████████████████████████████████████████████▓▓▒▒▓▓▒▒\n" +
                                "        ░░▒▒▓▓▓▓▓▓██████████████████████████████████████████████████████▓▓▓▓░░░░░░\n" +
                                "      ░░░░░░▓▓▓▓████████████████████████████████████████████████████████▓▓▒▒▒▒░░░░\n" +
                                "      ░░░░░░▓▓▓▓▓▓████████████████████████████████████████████████████▓▓▓▓░░░░░░░░\n" +
                                "  ░░░░░░    ▓▓▒▒░░██▓▓████████████████████████████████████████▓▓▓▓▓▓▓▓▓▓░░▒▒░░░░░░\n" +
                                "  ░░  ░░    ▒▒░░░░██▓▓████████████████████████████████████████▓▓▒▒▒▒▓▓▓▓  ░░░░░░░░\n" +
                                "  ░░          ░░░░▒▒▓▓████████████████████████████████▓▓▓▓▓▓▒▒▒▒▒▒░░▒▒░░  ░░░░░░░░\n" +
                                "  ░░            ░░▒▒▓▓▓▓▓▓██████████████████████████▒▒▒▒▒▒░░░░░░░░  ░░        ░░  \n" +
                                " ░░░            ░░░░▓▓▓▓▓▓██████████████▓▓▓▓████▓▓▓▓▒▒▒▒▒▒▒▒▒▒░░░░            ░░  \n" +
                                " ░              ░░░░▒▒▓▓▓▓██████████████▓▓██▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░░              ░░  \n" +
                                " ░░░            ░░░░▓▓██▓▓██████▓▓▒▒▒▒▓▓▓▓▓▓▒▒▒▒░░░░░░▒▒░░░░░░░░              ░░  \n" +
                                " ░░░      ░░    ░░░░▓▓▒▒▓▓████▓▓▒▒░░░░▒▒▓▓░░▒▒  ░░░░░░▒▒░░░░░░░░░░            ░░  \n" +
                                " ░░░  ░░░░░░░░░░░░░░▒▒▓▓▓▓████▓▓░░░░░░░░░░  ░░      ░░▒▒░░░░░░░░░░░░        ░░░░  \n" +
                                " ░░░░░  ░░▒▒▒▒░░░░░░░░▓▓▓▓████▓▓▒▒▒▒░░░░      ░░░░  ▒▒░░░░░░░░░░░░░░░░      ░░    \n" +
                                " ░░░░░░░░░░░▒▒▒▒▒▒▒▒░░▓▓▓▓██▓▓▓▓▒▒▒▒  ░░░░    ░░    ▒▒░░    ░░░░░░░░░░░░  ░░      \n" +
                                " ▒▒▒░░░░▒▒▒▒▒▒▒▒▓▓▒▒░░▒▒▓▓██▒▒▒▒▒▒░░░░░░░░    ░░  ░░▒▒░░      ░░░░░░░░░░░░░░░░░░  \n" +
                                " ▒▒▒▒▒▒▒▒▒▒▒▒▒░░▓▓▓▓▒▒▓▓████▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░▒▒▒▒░░  ░░░░░░░░░░░░░░▒▒░░▒▒▒▒\n" +
                                " ▓▒▒░░▒▒▒▒▒▒░░░░▓▓▓▓▓▓▓▓▓▓██▒▒▒▒▒▒▒▒▓▓▓▓▒▒░░░░░░▒▒▒▒▒▒░░▒▒▒▒▒▒░░░░░░▓▓▒▒░░▒▒▒▒░░▒▒\n" +
                                " ░▓▓░░░░▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓████▓▓▒▒▒▒▓▓██▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒░░▒▒██▓▓▓▓▒▒▒▒▒▒▓▓\n" +
                                " ▒░░░░▒▒▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓░░▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒██████▓▓▓▓▒▒▒▒░░\n");
        }
    }

    public static void clearScreen() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    //clear (lines) lines above terminal cursor
    public static void clearLines(int lines) {
        System.out.print("\033["+lines+"A\33[2K\r");
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        //enable ansi on some terminals
        AnsiConsole.systemInstall();
        //texts
        Text text = new Text();

        text.addStartText("\nAs you stir from your slumber, you find yourself in a desolate and frigid chamber. With naught but a flickering torch to guide you, you rise to your feet, the scant light illuminating the bleak surroundings. A palpable sense of danger fills the air, and you can hear the faint drip of water echoing off the walls. It seems you have stumbled upon a treacherous cave.");
        text.addStartText("\nYou sprinted through the dense forest, the sound of leaves crunching beneath your feet echoing around you. Suddenly, you fall into a deep hole, and everything fades to black. When you open your eyes, you're lying on the cold, hard ground, and the moonlight streaming down from the hole above is the only source of light. As you try to gather your bearings, you notice a flickering torch next to you, casting eerie shadows on the damp earth.");
        text.addStartText("\nA mysterious cave entrance looms before you, beckoning you with an otherworldly allure. Your curiosity piqued, you take the first steps inside. Suddenly, with a deafening rumble, the entrance collapses behind you, trapping you inside. Panic begins to set in, but as you fumble through your belongings, you find a flickering torch to guide your way.");
        text.addStartText("\nFollowing a night of revelry at the local tavern, you decide to make your way home and collapse into your bed. Exhaustion overcomes you, and you drift off into a deep slumber. However, when you awaken, the sound of dripping water echoes in your ears, and you realize that your bed has disappeared. You're lying on the hard ground, and the only light comes from a solitary torch by your side. As you look around, you see that you're in a cavernous chamber, with towering rock walls stretching up into the darkness above. You're alone in this strange and unknown place, with only your trusty torch to guide you.");
        text.addStartText("\nThe village where you grew up has been overrun by an army of enemies. In a desperate attempt to escape, you run deep into the forest, clutching a flickering torch in your hand. As the sounds of battle fade into the distance, you stumble upon a small cave entrance hidden among the trees. Driven by fear and instinct, you venture deeper and deeper into the cavern, feeling safer with every step. You hear strange noises outside the cave, but eventually, exhaustion overtakes you, and you fall into a deep slumber. When you awaken, you're disoriented and alone, trapped in a place you don't recognize. Your torch has burned low, but it's enough to cast an eerie glow on the rough-hewn walls of the cave. You must find a way out, but you're unsure where to start. You take a deep breath, steel yourself for whatever may come.");

        text.addDescriptionText("\nYou scan your surroundings, your eyes straining to pierce the gloom of the old cave chamber. The only sounds are the echoes of your own footsteps and the occasional drip of water. You try to recall how you got here, but the memories are foggy and indistinct. All you know is that you're alone, lost in the depths of the earth.\n");
        text.addDescriptionText("\nYou scan the cavern around you, your torch casting flickering shadows on the rough-hewn walls. The air is thick with the smell of dust and damp stone, and you hear nothing but the faint trickle of water in the distance. The chamber is vast and empty, with nothing but rocks and rubble strewn about the floor. You take a step forward, and your foot kicks up a cloud of dust, making you cough and choke.\n");
        text.addDescriptionText("\nAs your eyes adjust to the dim light, you realize that you're standing in the heart of a massive cave chamber. The sight sends shivers down your spine, and you can't help but feel a sense of dread. The walls stretch up into the inky blackness above, and the air is thick with the musty scent of damp earth and rock.\n" +
                "\n" +
                "You glance around, searching for some sign of an exit, but all you can see is the wavering glow of your torch as it casts strange shadows on the jagged stone formations around you. Your heart races with fear as you realize that you're completely alone in this vast and ominous cavern. But despite the terror that grips you, you know that you must press on, for the only way out is forward into the unknown.\n");
        text.addDescriptionText("\nYou realize with a start that you're standing in the heart of a vast, foreboding cavern, the walls towering high above you. The air is thick with the musty scent of damp earth, and the silence is punctuated only by the faint sound of dripping water. The darkness seems to press in on you from all sides, and a chill runs down your spine. You feel an overwhelming sense of fear and uncertainty, unsure of what dangers might lurk in the shadows. But even as you tremble with apprehension, you know that you must press on, your torch casting a flickering beam of light into the gloom as you set out into the unknown depths of the cave.\n");
        text.addDescriptionText("\nYou search every nook and cranny of the cavernous chamber, your heart pounding with the hope of finding some glimmer of hope or salvation. But as you scour the darkness, your torch flickering in the still air, you find nothing but rock and stone, the cold, unyielding walls of the cave closing in around you. Your fear begins to mount, a gnawing sense of dread filling your soul as you realize the enormity of your situation. There is no escape, no way out, no hope to be found in this desolate, forsaken place. You are alone with your torch, trapped in the belly of the earth, and the darkness threatens to swallow you whole.\n");

        text.addCrystalText("As you grip the crystal tightly, you sense that you are getting closer to your goal. Its radiant pulsations seem to be leading you towards the exit of this treacherous cave. With each step, the crystal's light intensifies, guiding you through the darkness.\n");
        text.addCrystalText("The crystal is pulsating at a reasonable frequency ,but you can feel a sense of unease creeping up within you. The walls of the cave seem to be closing in, and the shadows grow deeper with every step you take. The crystal's glow is your only source of hope, but its light isn't confident enough.\n");
        text.addCrystalText("Your heart sinks as you watch the crystal's pulsations. You feel lost in the labyrinth of the cave, with no way of knowing which way is out. The shadows close in around you, and the air grows thick with the stench of despair.\n");
        text.addCrystalText("The crystal's pulsations are barely visible, and you feel yourself becoming more and more disoriented with each passing moment. You can hear the sound of water dripping from somewhere deep within the cave, but it provides no comfort. You are alone in the darkness, with no way of knowing which way is up or down.\n");
        text.addCrystalText("You watch as the crystal's pulsations fade into nothingness, leaving you in complete darkness. Panic begins to set in, and you feel your heart pounding in your chest. The walls of the cave seem to be closing in on you, and the air grows thin and suffocating.\n");
        text.addCrystalText("The crystal in your hand barely pulsates, making you think if the faint pulsation is real or just your imagination. You feel completely lost. You stumble blindly through the darkness, your footfalls echoing off the cave walls. You are alone, afraid, and with no way of knowing whether you will ever find your way out of this wretched place.\n");

        Item i1 = new Item("Shiny Metal", "A piece of a shiny metal.");
        Item i2 = new Item("Diamond", "It's a diamond. It's value may be worth all your troubles.");
        Item i3 = new Item("Bright Crystal", "You do not recognize.");
        Item i4 = new Item("Memory of the Lonely Flower", "Gives you courage to continue.");
        Item i5 = new Item("Precious Gemstone", "You don't know it's value.");
        Item crystal = new Item("Weird Pulsating Crystal", "Sometimes it's light pulsates faster.");
        ChamberContent c1 = new ChamberContent("\nYour heart races as you scan the dimly-lit chamber for any sign of escape. Just when you think all is lost, a glimmer of hope catches your eye. A faint flicker of light dances on the walls. As you get closer, you see something that catches your interest.", 10, i1);
        ChamberContent c2 = new ChamberContent("\nAs you scour the shadowy chamber, your torch illuminating nothing but cold, unforgiving stone, you spy a glint of something in the distance. Heart racing, you move closer, your steps echoing in the silent chamber. And then, there it is - a small, glowing object, nestled among the rocks.", 30, i2);
        ChamberContent c3 = new ChamberContent("\nYour eyes strain against the darkness as you search the chamber for any sign of life. Just when you think all is lost, a faint glimmer catches your eye. You move closer, your heart pounding with excitement, until you see it - a shimmering crystal, glowing with an inner light.", 60, i3);
        ChamberContent c4 = new ChamberContent("\nThe cavernous chamber seems empty, and you start to despair. But then, something catches your eye - a flash of movement, a flicker of color. You move closer, heart racing with hope, until you see what it is - a small, delicate flower, blooming in the midst of the darkness.", 20, i4);
        ChamberContent c5 = new ChamberContent("\nYou had given up all hope of finding anything in this bleak, desolate chamber. But then, something glimmers in the corner of your eye, and you turn to see what it is. A small, glittering object, hidden among the rocks, catches your eye. You pick it up, heart racing with excitement, and realize that it is a precious gemstone, glinting in the dim torchlight.", 100, i5);
        ChamberContent c6 = new ChamberContent("\nAs you search the chamber, your eyes catch a glimpse of something peculiar. It's a crystal pulsing like a radar, illuminating the surrounding rocks with its faint glow. You pick it up, curious about its purpose. Could it be the key to finding the way out of this treacherous cave? But as you hold it in your hand, you realize that you have no idea what this strange crystal does. You can't help but feel a sense of unease as you continue your search, it feels like the pulsing of the crystal is guiding you into the unknown depths of the cavern.", 150, crystal);
        text.addContentObject(c1);
        text.addContentObject(c2);
        text.addContentObject(c3);
        text.addContentObject(c4);
        text.addContentObject(c5);
        text.addContentObject(c6);

        // Criando as câmaras
        Chamber chamber1 = new Chamber(0, text.getDescriptionText(0), text.getContentObject(0), false, new ArrayList<>());
        Chamber chamber2 = new Chamber(15, text.getDescriptionText(1), text.getContentObject(1), false, new ArrayList<>());
        Chamber chamber3 = new Chamber(20, text.getDescriptionText(2), text.getContentObject(2), false, new ArrayList<>());
        Chamber chamber4 = new Chamber(40, text.getDescriptionText(3), text.getContentObject(3), false, new ArrayList<>());
        Chamber chamber5 = new Chamber(27, text.getDescriptionText(4), text.getContentObject(4), true, new ArrayList<>());
        Chamber chamber6 = new Chamber(57, "camera 6", text.getContentObject(5), false, new ArrayList<>());

        // Criando o túnel
        Tunnel tunnel1 = new Tunnel(chamber1, chamber2, 20);
        Tunnel tunnel2 = new Tunnel(chamber1, chamber3, 21);
        Tunnel tunnel3 = new Tunnel(chamber2, chamber4, 22);
        Tunnel tunnel4 = new Tunnel(chamber4, chamber5, 23);
        Tunnel tunnel5 = new Tunnel(chamber3, chamber5, 24);
        Tunnel tunnel6 = new Tunnel(chamber1, chamber6, 25);

        // Criando a caverna
        List<Chamber> chambers = new ArrayList<>();
        chambers.add(chamber1);
        chambers.add(chamber2);
        chambers.add(chamber3);
        chambers.add(chamber4);
        chambers.add(chamber5);
        chambers.add(chamber6);

        Cave cave = new Cave(chambers);

        // Conectando as câmaras
        cave.connectChambers(tunnel1);
        cave.connectChambers(tunnel2);
        cave.connectChambers(tunnel3);
        cave.connectChambers(tunnel4);
        cave.connectChambers(tunnel5);
        cave.connectChambers(tunnel6);

        // Listando as câmaras
        //cave.listChambers();

        //System.out.println(cave.findEscape(chamber1));

        //clear screen
        clearScreen();

        //Game name art
        System.out.println("\n-__ /\\\\                              ,          ,- _~.                  \n" +
                "  ||  \\\\              '             ||         (' /|     _   ;          \n" +
                " /||__|| ,._-_  /'\\\\ \\\\  _-_   _-_ =||=       ((  ||    < \\, \\\\/\\  _-_  \n" +
                " \\||__||  ||   || || || || \\\\ ||    ||        ((  ||    /-|| || | || \\\\ \n" +
                "  ||  |,  ||   || || || ||/   ||    ||         ( / |   (( || || | ||/   \n" +
                "_-||-_/   \\\\,  \\\\,/  || \\\\,/  \\\\,/  \\\\,         -____-  \\/\\\\ \\\\/  \\\\,/  \n" +
                "  ||                 |;                                                 \n" +
                "                     /                                                  \n");
        //sound
        Scanner a = new Scanner(System.in);
        System.out.print("\nEnable audio (Y/N): ");
        String choice = a.nextLine();
        if(choice.equals("y") || choice.equals("Y")) {
            try {
                File f = new File("files/Dowland_-_Melancholy_Galliard.mp3");
                MP3Player mp3Player = new MP3Player(f);
                Thread newThread = new Thread(() -> {
                    File f2 = new File("files/Michael_Christian_Durrant_Classical_Guitar_Erik Satie_Gymnopedie_no_1_arr_Mermikides.mp3");
                    File f3 = new File("files/dark_forest_of_my_mind.mp3");
                    mp3Player.addToPlayList(f2);
                    mp3Player.addToPlayList(f3);
                    mp3Player.setShuffle(true);
                    mp3Player.skipForward();
                    mp3Player.skipBackward();
                    while(true) {
                        if(mp3Player.isStopped()) {
                            mp3Player.play();
                        }
                    }
                });
                newThread.start();
                while (!mp3Player.isStopped()) {
                    Thread.sleep(5000);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        clearLines(2);
        //variables of the game and player
        System.out.print("\nWrite the name of your character: ");
        String name = a.nextLine();
        Player player = new Player(name, chamber1, 200);
        PlayerInteraction playerInteraction = new PlayerInteraction(player);
        clearLines(3);

        //should be done as help
        System.out.println("Write 'quit game' at any moment to quit the game!");



        System.out.println(text.getStartText((int) randomInt(0, text.getStartTextLenght())));

        //game start
        String choice2;
        int choice3;
        boolean check;
        int round = 0;
        player.addItem(crystal);
        //need a reasonable condition (or maybe not)
        while(true){
            if (round != 0) {
                clearScreen();
            }
            ascChamber(player, cave);
            if (round == 0) {
                System.out.println(player.getLocation().getDescription());
            }
            if (player.containCrystal(crystal)){
                int distanceToExit = cave.findEscape(player.getLocation());
                System.out.println(distanceToExit);
                if(distanceToExit < 10) {
                    System.out.println(text.getCrystalText(0));
                } else if (distanceToExit < 30) {
                    System.out.println(text.getCrystalText(1));
                } else if (distanceToExit < 50) {
                    System.out.println(text.getCrystalText(2));
                } else if (distanceToExit < 70) {
                    System.out.println(text.getCrystalText(3));
                } else if (distanceToExit < 100) {
                    System.out.println(text.getCrystalText(4));
                } else if (distanceToExit >= 100) {
                    System.out.println(text.getCrystalText(5));
                }
                cave.clearChambersVariables(cave);
            }
            System.out.print("(1) Check deeply the chamber around you (costs 5 stamina)\n(2) Check if there is any other paths you can go\n(3) Check yourself (costs 2 stamina)\nWhat will you do? ");
            choice = a.nextLine();
            switch(choice){
                case "1":
                    playerInteraction.handleCheckCurrentChamber(player);
                    break;
                case "2":
                    System.out.println("\nThere are "+ player.getLocation().getConnections().size() +" paths surrounding you.\n");
                    System.out.print("(1) Check where one of these paths seems to led to (costs 10 stamina)\n(2) Choose path to follow (stamina cost equivalent to distance)\nWhat will you so? ");
                    choice2 = a.nextLine();
                    switch (choice2) {
                        case "1":
                            check = false;
                            while (check == false) {
                                System.out.print("What path do you want to check(number from 1 to " + player.getLocation().getConnections().size() + "): ");
                                choice3 = a.nextInt();
                                a.nextLine();
                                if (choice3 >= 1 && choice3 <= player.getLocation().getConnections().size()){
                                    playerInteraction.handleCheckSelectedChamber(player, choice3-1, (int)randomInt(0, 10));
                                    check = true;
                                }
                            }
                            break;
                        case "2":
                            check = false;
                            while (check == false) {
                                System.out.print("What path do you want to go(number from 1 to " + player.getLocation().getConnections().size() + "): ");
                                choice3 = a.nextInt();
                                a.nextLine();
                                if (choice3 >= 1 && choice3 <= player.getLocation().getConnections().size()){
                                    playerInteraction.handleGoToSelectedChamber(player, choice3-1);
                                    check = true;
                                }
                                if(player.getLocation().isExit() == true) {
                                    System.out.println("You've found the exit and managed to leave the cave. A cave that was never found again.");
                                    System.exit(0);
                                } else {
                                    System.out.println(player.getLocation().getDescription());
                                }
                                break;
                            }
                           break;
                        default:
                            break;
                   }
                   break;
                case "3":
                    playerInteraction.handlePlayerCheck(player);
                    break;
                case "quit game":
                    playerInteraction.handleQuitGame();
                    break;
                default:
                    break;
            }
            System.out.println("\nPress \"ENTER\" to continue...");
            a.nextLine();
            round++;
        }
    }
}
