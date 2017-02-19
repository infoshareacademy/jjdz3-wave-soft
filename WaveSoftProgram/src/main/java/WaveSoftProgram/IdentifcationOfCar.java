package WaveSoftProgram;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

/**
 * Created by piotr on 09.02.17.
 */

public class IdentifcationOfCar {

    //variable from json file which is passed to jsonFileReader() method
    private static String jsonData = "";

    //method which will be reading json files ("cars catalogue")
    public static void jsonFileReader() throws IOException {

        FileReader file = new FileReader("/home/piotr/IdeaProjects/jjdz3-wave-soft/WaveSoftProgram/carsCatalogue.json");
        BufferedReader br = new BufferedReader(file);
        String line;

        while ((line = br.readLine()) != null) {
            jsonData += line + "\n";
        }

        br.close();
    }


    public static void jsonHandler() {
        // Creating object from JSON file
        JSONObject obj = new JSONObject(jsonData);
        // Printing out first object from JSON file
        System.out.println("Data type: " + obj.getString("datatype"));
        // Getting an array from object value using its key
        JSONArray arr = obj.getJSONArray("data");

        //for loop which iterates on object's value in table.
        for (int i = 0; i <= arr.length(); i++) {
            JSONObject obj1 = arr.getJSONObject(i);
            String id = obj1.getString("id");
            String name = obj1.getString("name");
            String nameClear = obj1.getString("name_clear");
            Boolean hasImage = obj1.getBoolean("has_image");
            String link = obj1.getString("link");
            System.out.println("ID:" + id + "\nName: " + name +
                                "\nName(lower case): " + nameClear +
                                "\nHas Image: " + hasImage + "\nLink: " + link);
            System.out.println("\n");
        }
    }
}
