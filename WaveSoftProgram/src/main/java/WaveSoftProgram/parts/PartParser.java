package WaveSoftProgram.parts;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;*/
/**
 * Created by piotr_gy on 22.02.17.
 */
public class PartParser {
private List<PlaceInCar>placeInCarList = new ArrayList<PlaceInCar>();

    public PartParser() {

        try {
        ObjectMapper mapper = new ObjectMapper(); /*./WaveSoftProgram/*/

            JsonNode rootArray = mapper.readTree(new File("src/main/resources/parts.json"));


            //odczytaj każdy element place_in_car
            for(JsonNode rootNode : rootArray){
                //odczytaj name_of_place
                PlaceInCar placeInCar = new PlaceInCar();
                JsonNode nameOfPlaceNode = rootNode.path("name_of_place");
                placeInCar.setNameOfPlace(nameOfPlaceNode.asText());


                //odczytaj każdy element part_category
                JsonNode partCategoryArray = rootArray.path("part_category");
                List<PartCategory>partCategoryList = new ArrayList<PartCategory>();

                for(JsonNode partCategoryNode : partCategoryArray){
                    //odczytaj category_name
                    PartCategory partCategory = new PartCategory();
                    JsonNode categoryNameNode = partCategoryNode.path("category_name");
                    partCategory.setCategoryName(categoryNameNode.asText());

                    //odczytaj każdy element parts
                    JsonNode partsArray = partCategoryArray.path("parts");
                    List<Part>partList = new ArrayList<Part>();

                    for (JsonNode part : partsArray){
                        //odczytaj part_id

                        //odczytaj search_phrase

                    }

                    partCategoryList.add(partCategory);
                }

                placeInCarList.add(placeInCar);
            }








        //full data binding - doesn't work
        /*
            ObjectMapper mapper = new ObjectMapper();
            PlaceInCar placeInCar = mapper.readValue(new File("./WaveSoftProgram/src/main/resources/parts.json"), PlaceInCar.class);


            System.out.println(placeInCar);*/

        }
        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

}
//PartCategory partCategory  = new PartCategory();