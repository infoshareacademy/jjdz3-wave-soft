package WaveSoftProgram;

//klasa odpowiadająca za menu programu

import WaveSoftProgram.parts.PartParser;
import org.json.JSONException;

import java.io.IOException;

public class Menu {

    private String menuTekst1 = "1. Znajdź część której szukasz na Allegro.\n";
    private String menuTekst2 = "2. Znajdź część której szukasz na ebay.\n";
    private String menuTekst3 = "3. Identyfikacja auta po serii pytań. \n";
    private String menuTekst4 = "4. Identyfikacja pojazdu po kodzie Aztec. \n";
    private String menuTekst5 = "5. Szybka diagnostyka samochodowa.  \n";
    private String menuTekst6 = "   Wybierz numer instrukcji. \n";
    private String menuTekst7 = "   Powrót do menu głównego z lub zakończenie \n   działania programu q.  ";


    void showLogo() {

        System.out.println("");
        System.out.println("                Find Your Car Part                  \n");
        System.out.println("        ______________________");
        System.out.println("        |^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^| _______");
        System.out.println("        | The FYCP Truck!     | |\"\"'|\"\"\\__");
        System.out.println("        |____________________ |-|___|__|__|)< ");
        System.out.println("        |(@)(@)\"'        ''|(@) (@)     (@)   \n");
        System.out.println("");


    }

    void showMenu() {


        System.out.println("----------------------------------------------------");
        System.out.println("|                      MENU                        | ");
        System.out.println("---------------------------------------------------- \n");
        System.out.println(menuTekst1);
        System.out.println(menuTekst2);
        System.out.println(menuTekst3);
        System.out.println(menuTekst4);
        System.out.println(menuTekst5);
        System.out.println(menuTekst6);
        System.out.println(menuTekst7);


    }
         void menuLogic(int choice) throws IOException, JSONException {

             //metoda obsługująca wybór wprowadzony przez użytkownika

            switch (choice) {

                case '1':
                    System.out.println("1. WYBRAŁEŚ Znajdź część której szukasz na Allegro.\n");
                    PartParser partParser = new PartParser();

                    break;
                case '2':
                    System.out.println("2. WYBRAŁEŚ Znajdź część której szukasz na ebay.\n");


                    break;
                case '3':


                    break;
                case '4':

                    FindingCarByAztecCode carByAztec = new FindingCarByAztecCode();

                    carByAztec.jsonFileReader();
                    carByAztec.jsonHandler();

                    break;
                case '5':
                    System.out.println("5. WYBRAŁEŚ Szybka diagnostyka samochodowa  \n");

                    break;

            }

        }

        //metoda walidująca wybór wprowadzony przez użytkownika

        boolean isValid(int ch) {
            if(ch < '1' | ch > '7' & ch != 'q' & ch != 'z') return false;
            else return true;
        }

        //metoda wywoływana w przypadku wciśnięcia q
        void progEnding() {

            System.out.println("");
            System.out.println("   Zakończono...\n");
            System.out.println("-----------------------------------------------------");

        }




}
