package WaveSoftProgram;

//klasa odpowiadająca za menu programu

import org.json.JSONException;

import java.io.IOException;

public class Menu {

    private String menuTekst1 = "1. Znajdź kategorię części której szukasz na Allegro.\n";
    private String menuTekst2 = "2. Znajdź część której szukasz na Allegro.\n";
    private String menuTekst3 = "3. Znajdź część której szukasz na ebay.\n";
    private String menuTekst4 = "4. Identyfikacja auta po serii pytań. \n";
    private String menuTekst5 = "5. Identyfikacja pojazdu po kodzie Aztec. \n";
    private String menuTekst6 = "6. Szybka diagnostyka samochodowa.  \n";
    private String menuTekst7 = "   Wybierz numer instrukcji. \n";
    private String menuTekst8 = "   Powrót do menu głównego z lub zakończenie \n   działania programu q.  ";


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
        System.out.println(menuTekst8);


    }
    void menuLogic(int choice) throws IOException, JSONException {

        //metoda obsługująca wybór wprowadzony przez użytkownika

        switch (choice) {

            case '1':

                FindingAllegroCategory allegroCategory = new FindingAllegroCategory();
                allegroCategory.jsonFileReader();
                allegroCategory.jsonHandler();


                break;
            case '2':

                FindingPart allegro = new FindingPart();
                allegro.findPartMenu("parts.json");
                this.showMenu();

                break;
            case '3':

                FindingPart ebay = new FindingPart();
                ebay.findPartMenu("parts_ebay.json");
                this.showMenu();


                break;
            case '4':

                IdentifcationOfCar idOfCar = new IdentifcationOfCar();
                idOfCar.jsonFileReader();
                idOfCar.menu2();



                break;
            case '5':
                FindingCarByAztecCode carByAztec = new FindingCarByAztecCode();
                carByAztec.jsonFileReader();
                carByAztec.jsonHandler();

                break;
            case '6':
                System.out.println("6. WYBRAŁEŚ Szybka diagnostyka samochodowa  \n");

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
