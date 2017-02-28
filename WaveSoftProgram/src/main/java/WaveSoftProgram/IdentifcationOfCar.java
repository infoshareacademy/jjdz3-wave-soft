package WaveSoftProgram;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

/**
 * Created by piotr on 09.02.17.
 */

public class IdentifcationOfCar {

    //variable from json file which is passed to jsonFileReader() method
    private static String jsonData = "";

    //variables for innner menu
    private static String MENU_QUESTION_BRAND_FOR_USER = "Podaj markę samochodu której szukasz";
    private static String MENU_QUESTION_ID_FOR_USER = "Podaj ID samochodu którego szukasz";
    private static String MENU_CHOSEN_VEHICLE = "Wybrany pojazd:";
    private static String MENU_VEHICLE_ID = "ID: ";
    private static String MENU_VEHICLE_NAME = "\nNazwa pojazdu: ";
    private static String VEHICLE_IMAGE = "\nZdjęcie pojazdu: ";
    private static String VEHICLE_LINK = "\nLink do historii przeglądów pojazdu: ";
    private static String VEHICLE_IMAGE_TRUE = "(Wyświetlenie zdjęcia pojazdu)";
    private static String VEHICLE_IMAGE_FALSE = "Brak zdjęcia pojazdu w bazie danych";

    //variable for user input
    private static String chosenVehicleBrand;
    private static String chosenVehicleBrandUpper;
    private static String chosenVehicleBrandLower;

    //method which will be reading json files ("cars catalogue")
    public static void jsonFileReader() throws IOException {

        FileReader file = new FileReader("carsCatalogue.json");
        BufferedReader br = new BufferedReader(file);
        String line;

        while ((line = br.readLine()) != null) {
            jsonData += line + "\n";
        }

        br.close();
    }

    public static void menu2() throws JSONException {

        //new variables for menu
        boolean quit = false;
        int choice;
        while(!quit){
            printInstructions();
            System.out.println("Co wybierasz ?");
            Menu menuAutoApp = new Menu();
            Scanner scanner = new Scanner(System.in);
            //selecting list of options
            choice = scanner.nextInt();
            //clear input buffer
            scanner.nextLine();
            switch(choice){
                case 1:
                    searchByName();
                    break;
                case 2:
                    searchById();
                    break;
                case 3:
                    menuAutoApp.showMenu();
                    quit = true;
                    break;
                case 4:
                    menuAutoApp.progEnding();
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("Wyszukaj po nazwie samochodu - wciśnij 1");
        System.out.println("Wyszukaj po ID samochodu - wciśnij 2");
        System.out.println("Wyjdź do głównego menu - wciśnij 3");
        System.out.println("zakończ program - wciśnij 4");
    }

    public static void searchByName() throws JSONException {

        //Scanner for user input
        Scanner scan = new Scanner(System.in);
        // Creating object from JSON file
        JSONObject obj = new JSONObject(jsonData);

       /* Unnecessary line of code, left for information purpose
        // Printing out first object from JSON file
        System.out.println("Data type: " + obj.getString("datatype"));
       */

        // Getting an array from object value using its key
        JSONArray arr = obj.getJSONArray("data");

        //Starting inner menu (menu of this class)
        System.out.println(MENU_QUESTION_BRAND_FOR_USER);
        //assign user input
        chosenVehicleBrand = scan.nextLine();
        //to avoid errors - setting input to upper case
        chosenVehicleBrandUpper = chosenVehicleBrand.toUpperCase();

        //for loop which iterates on object's value in table.
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj1 = arr.getJSONObject(i);
            String id = obj1.getString("id");
            String name = obj1.getString("name");
            /* unused variable, left for information purpose
            String nameClear = obj1.getString("name_clear");
            */
            Boolean hasImage = obj1.getBoolean("has_image");
            String link = obj1.getString("link");

            //new condition for finding vehicle which user is searching in database
            if (obj1.getString("name").contains(chosenVehicleBrandUpper)) {
                System.out.println(MENU_CHOSEN_VEHICLE);
                System.out.print(MENU_VEHICLE_ID + id + MENU_VEHICLE_NAME + name);

                //next condition for checking if given vehicle have
                //photo (value "true" for key "has_image") it will be
                //printed on the screen (later, when project will be
                //in more advanced phase)
                if (hasImage == false) {
                    System.out.print(VEHICLE_IMAGE + VEHICLE_IMAGE_FALSE);
                } else {
                    System.out.print(VEHICLE_IMAGE + VEHICLE_IMAGE_TRUE);
                }

                System.out.println(VEHICLE_LINK + link + "\n");
            }
        }
    }

    public static void searchById() throws JSONException {

        //Scanner for user input
        Scanner scan = new Scanner(System.in);
        // Creating object from JSON file
        JSONObject obj = new JSONObject(jsonData);

       /* Unnecessary line of code, left for information purpose
        // Printing out first object from JSON file
        System.out.println("Data type: " + obj.getString("datatype"));
       */

        // Getting an array from object value using its key
        JSONArray arr = obj.getJSONArray("data");

        //Starting inner menu (menu of this class)
        System.out.println(MENU_QUESTION_ID_FOR_USER);
        //assign user input
        chosenVehicleBrand = scan.nextLine();
        //to avoid errors - setting input to upper case
        chosenVehicleBrandLower = chosenVehicleBrand.toLowerCase();

        //for loop which iterates on object's value in table.
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj1 = arr.getJSONObject(i);
            String id = obj1.getString("id");
            String name = obj1.getString("name");
            /* unused variable, left for information purpose
            String nameClear = obj1.getString("name_clear");
            */
            Boolean hasImage = obj1.getBoolean("has_image");
            String link = obj1.getString("link");

            //new condition for finding vehicle which user is searching in database
            if (obj1.getString("id").equals(chosenVehicleBrandLower)) {
                System.out.println(MENU_CHOSEN_VEHICLE);
                System.out.print(MENU_VEHICLE_ID + id + MENU_VEHICLE_NAME + name);

                //next condition for checking if given vehicle have
                //photo (value "true" for key "has_image") it will be
                //printed on the screen (later, when project will be
                //in more advanced phase)
                if (hasImage == false) {
                    System.out.print(VEHICLE_IMAGE + VEHICLE_IMAGE_FALSE);
                } else {
                    System.out.print(VEHICLE_IMAGE + VEHICLE_IMAGE_TRUE);
                }
                System.out.println(VEHICLE_LINK + link + "\n");
                }
            }
        }
    }
