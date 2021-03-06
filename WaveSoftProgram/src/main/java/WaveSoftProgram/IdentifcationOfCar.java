package WaveSoftProgram;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by piotr on 09.02.17.
 */

public class IdentifcationOfCar {

    //variable from json file which is passed to jsonFileReader() method
    private static String jsonData = "";

    //variables for inner menu
    private static String MENU_QUESTION_BRAND_FOR_USER = "Podaj markę samochodu której szukasz";
    private static String MENU_QUESTION_ID_FOR_USER = "Podaj ID samochodu którego szukasz";
    private static String MENU_CHOSEN_VEHICLE = "Wybrany pojazd:";
    private static String MENU_VEHICLE_ID = "ID: ";
    private static String MENU_VEHICLE_NAME = "\nNazwa pojazdu: ";
    private static String VEHICLE_IMAGE = "\nZdjęcie pojazdu: ";
    private static String VEHICLE_LINK = "\nLink do historii przeglądów pojazdu: ";
    private static String VEHICLE_IMAGE_TRUE = "(Wyświetlenie zdjęcia pojazdu)";
    private static String VEHICLE_IMAGE_FALSE = "Brak zdjęcia pojazdu w bazie danych";
    private static String INSTRUCTION_MENU_SEARCH_BY_NAME = "Wyszukaj po nazwie samochodu - wciśnij 1";
    private static String INSTRUCTION_MENU_SEARCH_BY_ID = "Wyszukaj po ID samochodu - wciśnij 2";
    private static String INSTRUCTION_MENU_BACK_TO_MAIN_MENU = "Wyjdź do głównego menu - wciśnij 3";
    private static String INSTRUCTION_MENU_EXIT = "zakończ program - wciśnij 4";
    private static String QUESTION_FOR_USER = "Co wybierasz ?";

    //variable for user input
    private static String chosenVehicleBrand;
    private static String chosenVehicleBrandUpper;
    private static String chosenVehicleBrandLower;
    private static String USER_INPUT_FAILURE = "\nNie ma takiego pojazdu! Spróbuj jeszcze raz!\n";
    private static String USER_INPUT_FAILURE_NUMBER_TWO = "\nPodałeś złą wartość! Spróbuj jeszcze raz!\n";

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
            System.out.println(QUESTION_FOR_USER);
            Scanner scanner = new Scanner(System.in);
            try {
                //selecting list of options
                Menu menuAutoApp = new Menu();
                choice = scanner.nextInt();
                //clear input buffer
                scanner.nextLine();
               switch (choice) {
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
            } catch (InputMismatchException e) {
                System.out.println(USER_INPUT_FAILURE_NUMBER_TWO);
//              System.err.println("InputMismatchException: " + e.getMessage());
            }
        }
    }

    public static void printInstructions() {
        System.out.println(INSTRUCTION_MENU_SEARCH_BY_NAME);
        System.out.println(INSTRUCTION_MENU_SEARCH_BY_ID);
        System.out.println(INSTRUCTION_MENU_BACK_TO_MAIN_MENU);
        System.out.println(INSTRUCTION_MENU_EXIT);
    }

    public static void searchByName() throws JSONException {

        //Scanner for user input
        Scanner scan = new Scanner(System.in);
        // Creating object from JSON file
        JSONObject objectFromJSON = new JSONObject(jsonData);

       /* Unnecessary line of code, left for information purpose
        // Printing out first object from JSON file
        System.out.println("Data type: " + objectFromJSON.getString("datatype"));
       */

        // Getting an array from object value using its key
        JSONArray arrayFromJSONObject = objectFromJSON.getJSONArray("data");
        //Starting inner menu (menu of this class)
        System.out.println(MENU_QUESTION_BRAND_FOR_USER);
        //assign user input
        chosenVehicleBrand = scan.nextLine();
        //to avoid errors - setting input to upper case
        chosenVehicleBrandUpper = chosenVehicleBrand.toUpperCase();
        //List created to validate users input
        List<String> foundedVehicleByName = new ArrayList<String>();
        //for loop which iterates on object's value in table.
        for (int i = 0; i < arrayFromJSONObject.length(); i++) {
            JSONObject searchedObject = arrayFromJSONObject.getJSONObject(i);
            String id = searchedObject.getString("id");
                String name = searchedObject.getString("name");
                Boolean hasImage = searchedObject.getBoolean("has_image");
                String link = searchedObject.getString("link");

                //new condition for finding vehicle which user is searching in database
                if (searchedObject.getString("name").contains(chosenVehicleBrandUpper)) {
                    foundedVehicleByName.add(chosenVehicleBrandUpper);
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
                //if statement for validation user input
                if (foundedVehicleByName.isEmpty()) {
                    System.out.println(USER_INPUT_FAILURE);
                }
    }

    public static void searchById() throws JSONException {

        //Scanner for user input
        Scanner scan = new Scanner(System.in);
        // Creating object from JSON file
        JSONObject objectFromJSON = new JSONObject(jsonData);

       /* Unnecessary line of code, left for information purpose
        // Printing out first object from JSON file
        System.out.println("Data type: " + objectFromJSON.getString("datatype"));
       */

        // Getting an array from object value using its key
        JSONArray arrayFromJSONObject = objectFromJSON.getJSONArray("data");

        //Starting inner menu (menu of this class)
        System.out.println(MENU_QUESTION_ID_FOR_USER);
        //assign user input
        chosenVehicleBrand = scan.nextLine();
        //to avoid errors - setting input to upper case
        chosenVehicleBrandLower = chosenVehicleBrand.toLowerCase();

        List<String> foundedVehicleById = new ArrayList<String>();
        //for loop which iterates on object's value in table.
        for (int i = 0; i < arrayFromJSONObject.length(); i++) {
            JSONObject searchedObject = arrayFromJSONObject.getJSONObject(i);
            String id = searchedObject.getString("id");
            String name = searchedObject.getString("name");
            Boolean hasImage = searchedObject.getBoolean("has_image");
            String link = searchedObject.getString("link");

            //new condition for finding vehicle which user is searching in database
            if (searchedObject.getString("id").equals(chosenVehicleBrandLower)) {
                foundedVehicleById.add(chosenVehicleBrandLower);
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
            //if statement for validation user input
            if (foundedVehicleById.isEmpty()) {
                System.out.println(USER_INPUT_FAILURE);
            }
    }
    }
