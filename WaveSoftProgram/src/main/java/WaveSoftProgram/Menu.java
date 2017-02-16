package WaveSoftProgram;

//klasa odpowiadająca za menu programu

import org.json.JSONException;

import java.io.IOException;

public class Menu {


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
        System.out.println("1. Znajdź część której szukasz na Allegro.\n");
        System.out.println("2. Znajdź część której szukasz na ebay.\n");
        System.out.println("3. Identyfikacja auta po serii pytań. \n");
        System.out.println("4. Identyfikacja pojazdu po kodzie Aztec. \n");
        System.out.println("5. Szybka diagnostyka samochodowa.  \n");
        System.out.println("   Wybierz numer instrukcji. \n");
        System.out.println("   Powrót do menu głównego z lub zakończenie \n   działania programu q.  ");


    }
         void menuLogic(int choice) throws IOException, JSONException {

             //metoda obsługująca wybór wprowadzony przez użytkownika

            switch (choice) {

                case '1':
                    System.out.println("1. WYBRAŁEŚ Znajdź część której szukasz na Allegro.\n");

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
