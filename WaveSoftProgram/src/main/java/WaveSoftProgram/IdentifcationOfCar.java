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
    private static String questionForUser = "Podaj markę samochodu której szukasz";
    private static String textJHMenu = "Wybrany pojazd:";
    private static String textID = "ID: ";
    private static String textName = "\nNazwa pojazdu: ";
    private static String vehicleImage = "\nZdjęcie pojazdu: ";
    private static String vehicleLink = "\nLink do historii przeglądów pojazdu: ";
    private static String vehicleImageTrue = "(Wyświetlenie zdjęcia pojazdu)";
    private static String vehicleImageFalse = "Brak zdjęcia pojazdu w bazie danych";

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
        System.out.println(questionForUser);
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
                System.out.println(textJHMenu);
                System.out.print(textID + id + textName + name);

                //next condition for checking if given vehicle have
                //photo (value "true" for key "has_image") it will be
                //printed on the screen (later, when project will be
                //in more advanced phase)
                if (hasImage == false) {
                    System.out.print(vehicleImage + vehicleImageFalse);
                } else {
                    System.out.print(vehicleImage + vehicleImageTrue);
                }

                System.out.println(vehicleLink + link);
            } else if (chosenVehicleBrand.equals("q")) {
                menuAutoApp.progEnding();
                break;
            } else if (chosenVehicleBrand.equals("z")) {
                menuAutoApp.showMenu();
                break;
            }
        }
    }
}
