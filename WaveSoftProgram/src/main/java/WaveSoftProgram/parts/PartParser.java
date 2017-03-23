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


/**
 * Class describes an object of a questionnaire for searching a car part and creating it from a *.json file.
 */
public class PartParser {
    private List<PlaceInCar> placeInCarList = new ArrayList<PlaceInCar>();

    /**
     * Creates an object of a questionnaire. Parses a json file and builds a tree model.
     * @see <a href="https://www.mkyong.com/java/jackson-tree-model-example/">Example of Jackson Tree Model</a>     *
     */
    public PartParser(String fileName) {

        try {
            ObjectMapper mapper = new ObjectMapper(); /*./WaveSoftProgram "src/main/resources/parts.json"/*/

            ClassLoader classLoader = this.getClass().getClassLoader();
            String filePath = classLoader.getResource(fileName).getFile();

            JsonNode mainNode = mapper.readTree(new File(filePath));
            JsonNode rootArray = mainNode.path("place_in_car");


            //odczytaj każdy element place_in_car
            for (JsonNode rootNode : rootArray) {
                //odczytaj name_of_place
                PlaceInCar placeInCar = new PlaceInCar();
                JsonNode nameOfPlaceNode = rootNode.path("name_of_place");
                placeInCar.setNameOfPlace(nameOfPlaceNode.asText());


                //odczytaj każdy element part_category
                JsonNode partCategoryArray = rootNode.path("part_category");
                List<PartCategory> partCategoryList = new ArrayList<PartCategory>();
                placeInCar.setCategories(partCategoryList);


                for (JsonNode partCategoryNode : partCategoryArray) {
                    //odczytaj category_name
                    PartCategory partCategory = new PartCategory();
                    JsonNode categoryNameNode = partCategoryNode.path("category_name");
                    partCategory.setCategoryName(categoryNameNode.asText());

                    //odczytaj każdy element parts
                    JsonNode partsArray = partCategoryNode.path("parts");
                    List<Part> partList = new ArrayList<Part>();
                    partCategory.setParts(partList);


                    for (JsonNode partNode : partsArray) {
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

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //System.out.println(getPlaceInCarList());
    }

    /**
     * Standard POJO getter.
     * @return Reference to the list of places in the car, where an autopart is broken.
     */
    public List<PlaceInCar> getPlaceInCarList() {
        return placeInCarList;
    }
}
