package WaveSoftProgram;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class JsonHandling implements MenuTextOption {

    private static final Logger LOGGER = Logger.getLogger(JsonHandling.class.getName());
    private static String jsonData = "";

    public static void jsonFileReader(String jsonFile) throws IOException {

        FileReader file = new FileReader(String.valueOf(jsonFile));
        BufferedReader br = new BufferedReader(file);
        String line;

        while ((line = br.readLine()) != null) {
            jsonData += line + "\n";
        }
        br.close();
    }

    public static void iteratingJSON() throws JSONException {
        JSONObject objectFromJSON = new JSONObject(jsonData);
        JSONArray arrayFromJSONObject = objectFromJSON.getJSONArray("data");
        List<String> listOfKeys = new ArrayList<String>();
        for(int i = 0; i < arrayFromJSONObject.length(); i++) {
            JSONObject searchedObject = arrayFromJSONObject.getJSONObject(i);
            String nazwaAwarii = searchedObject.getString("awaria");
            listOfKeys.add(nazwaAwarii);
        }
        for(String element : listOfKeys) {
            System.out.println(element);
        }
    }

    public static void searchCertainFault() throws JSONException {

        Scanner scan = new Scanner(System.in);
        JSONObject objectFromJSON = new JSONObject(jsonData);
        JSONArray arrayFromJSONObject = objectFromJSON.getJSONArray("data");
        LOGGER.info(SEARCHING_QUESTION);
        //assign user input
        String chosenVehicleFaultName = scan.nextLine();
        //to avoid errors - setting input to lower case
        String chosenVehicleFaultNameLower = chosenVehicleFaultName.toLowerCase();
        //List created to validate users input
        List<String> foundedVehicleByFaultName = new ArrayList<String>();
        //for loop which iterates on object's value in table.
        for (int i = 0; i < arrayFromJSONObject.length(); i++) {
            JSONObject searchedObject = arrayFromJSONObject.getJSONObject(i);
            String nazwaAwarii = searchedObject.getString("awaria");
            String opisAwarii = searchedObject.getString("opisAwarii");
            String potrzebnaCzesc = searchedObject.getString("potrzebnaCzesc");

            //new condition for finding vehicle fault which user is searching in database
            if (searchedObject.getString("awaria").equals(chosenVehicleFaultNameLower)) {
                foundedVehicleByFaultName.add(chosenVehicleFaultNameLower);
                LOGGER.info("\n" + CHOSEN_FAULT + "\n"
                                + FAULT_NAME + nazwaAwarii + "\n"
                                + FAULT_DESCRIPTION + opisAwarii + "\n"
                                + NEEDED_PART + potrzebnaCzesc + "\n");
            }
        }
        if (foundedVehicleByFaultName.isEmpty()) {
            LOGGER.info(ERROR_INPUT);
        }
    }
}
