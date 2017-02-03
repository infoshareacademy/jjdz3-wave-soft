package WaveSoft.Menu;

import java.io.IOException;
import java.util.Scanner;

public class MenuStartowe {
    //// TODO: 29.01.17 start menu
    private static int menu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *             MENU STARTOWE            *");
        System.out.println("     ****************************************");
        System.out.println("     1. Rozpocznij ankiete");
        System.out.println("     2. Zakoncz program");

        Scanner in = new Scanner(System.in);
        int w = (int)in.nextInt();
        return w;
    }

    public static void choice() throws IOException {

        int number = menu();
        while (number != 2) {

            switch (number) {
                case 1:

                    System.out.println("Przechodzi do funkcji rozpoczynajacej ankiete");
                    break;

                default:
                    System.out.println("Wybierz dostepne opcje");

            }
            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            number = menu();
        }

    }
}