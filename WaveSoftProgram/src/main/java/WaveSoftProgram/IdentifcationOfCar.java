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
    private static String MENU_QUESTION_FOR_USER = "Podaj markę samochodu której szukasz";
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


    public static void jsonHandler() throws JSONException {

        //Scanner for user input
        Scanner scan = new Scanner(System.in);
        // Creating object from JSON file
        JSONObject obj = new JSONObject(jsonData);
        //maintenance of menu
        Menu menuAutoApp = new Menu();

       /* Unnecessary line of code, left for information purpose
        // Printing out first object from JSON file
        System.out.println("Data type: " + obj.getString("datatype"));
       */

        // Getting an array from object value using its key
        JSONArray arr = obj.getJSONArray("data");

        //Starting inner menu (menu of this class)
        System.out.println(MENU_QUESTION_FOR_USER);
        //assign user input
        chosenVehicleBrand = scan.next();
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
            if (chosenVehicleBrandUpper.equals(obj1.getString("name"))) {
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

                System.out.println(VEHICLE_LINK + link);
            } else if (chosenVehicleBrand.equals("q")) {
                menuAutoApp.progEnding();
                break;
            } else if (chosenVehicleBrand.equals("z")) {
                menuAutoApp.showMenu();
                break;
            }
        }

        IdentifcationOfCar idOfCar2 = new IdentifcationOfCar();
        idOfCar2.jsonHandler();

    }
}
