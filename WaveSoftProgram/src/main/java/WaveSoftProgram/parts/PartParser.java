package WaveSoftProgram.parts;
import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
/**
 * Created by piotr_gy on 22.02.17.
 */
public class PartParser {
    public PartParser() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            PlaceInCar placeInCar = mapper.readValue(new File("src/main/resources/parts.json"), PlaceInCar.class);


            System.out.println(placeInCar);

        }
        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

}
