package WaveSoftProgram;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindingCarByAztecCode {


    //variable from json file which is passed to jsonFileReader() method
    private static String jsonFile = "";


    //method which will be reading json files ("cars catalogue")
    public static void jsonFileReader() throws IOException {

        FileReader file = new FileReader("Aztec_car.json");
        BufferedReader br = new BufferedReader(file);
        String line;


        while ((line = br.readLine()) != null) {
            jsonFile += line + "\n";
        }

        br.close();
    }



    public static void jsonHandler() throws JSONException, IOException {


        Scanner scan = new Scanner(System.in);
        JSONObject obj = new JSONObject(jsonFile);
        Menu menuAutoApp = new Menu();
        String programInstruction = "Podaj kod Aztec pojazdu lub wciśnij \n z aby wrócić do menu głównego lub q  \n aby zakończyć program. \n";

        JSONArray arrJSON = obj.getJSONArray("data");


        System.out.println(programInstruction);
        String in;
        in = scan.nextLine();


        //for loop that prints out car specification by aztec code



        for (int i = 0; i < arrJSON.length(); i++) {

            JSONObject obj1 = arrJSON.getJSONObject(i);
            String aztecCode = obj1.getString("aztecCode");
            String make = obj1.getString("make");
            String model = obj1.getString("model");
            String modelYear = obj1.getString("modelYear");
            String engine = obj1.getString("engine");


            if (in.equals(obj1.getString("aztecCode"))) {

                System.out.println("-----------------------------------\n");
                System.out.println(" ");
                System.out.println("Kod Aztec: " + aztecCode + "\nMarka: " + make
                        + "\nModel: " + model +
                        "\nRocznik: " + modelYear + "\nEngine: " + engine);
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("-----------------------------------\n");
                break;


            } else if (in.equals("q")) {

                menuAutoApp.progEnding();

                break;
            } else if (in.equals("z")) {

                menuAutoApp.showMenu();

                break;
            }

        }

        FindingCarByAztecCode carByAztec2 = new FindingCarByAztecCode();
        carByAztec2.jsonHandler();


    }
}

