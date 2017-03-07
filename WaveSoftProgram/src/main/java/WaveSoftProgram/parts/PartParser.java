package WaveSoftProgram.parts;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.fasterxml.jackson.core.JsonGenerationException;
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

            JsonNode mainArray = mapper.readTree(new File("src/main/resources/parts.json"));
            JsonNode rootArray = mainArray.path("place_in_car");


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

                    for (JsonNode partNode : partsArray){
                        Part part = new Part();

                        //odczytaj part_id
                        part.setPartId(partNode.path("part_id").asText());

                        //odczytaj search_phrase
                        part.setSearchPhrase(partNode.path("search_phrase").asText());

                        partList.add(part);
                    }

                    partCategoryList.add(partCategory);
                }

                placeInCarList.add(placeInCar);
            }

        }
        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }



    }

    public List<PlaceInCar> getPlaceInCarList() {
        return placeInCarList;
    }
}
