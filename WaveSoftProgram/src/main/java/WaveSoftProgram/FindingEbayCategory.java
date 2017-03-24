package WaveSoftProgram;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindingEbayCategory {

    //variable from json file which is passed to jsonFileReader() method
    private static String jsonFile = "";


    //method which will be reading json files ("cars catalogue")
    public static void jsonFileReader() throws IOException {

        FileReader file = new FileReader("eBayCaregories.json");
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
        String programInstruction = "Znajdź część której szukasz na eBay.";

        JSONArray arrJSON = obj.getJSONArray("data");


        System.out.println(programInstruction);
        String in;
        in = scan.nextLine();


        //for loop that prints out car specification by aztec code



        for (int i = 0; i < arrJSON.length(); i++) {

            JSONObject obj1 = arrJSON.getJSONObject(i);
            String categoryPart = obj1.getString("podkategoria");
            String link = obj1.getString("link");



            if (in.equalsIgnoreCase(obj1.getString("czesc"))) {

                System.out.println("-----------------------------------\n");
                System.out.println(" ");
                System.out.println("Kategoria: " + categoryPart + "\nLink do kategorii na eBay: " +
                        link);
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("-----------------------------------\n");


                FindingEbayCategory idOfCar2 = new FindingEbayCategory();
                idOfCar2.jsonHandler();
                break;


            } else if (in.equals("q")) {

                menuAutoApp.progEnding();

                break;
            } else if (in.equals("z")) {

                menuAutoApp.showMenu();

                break;
            }

        }




    }
}


