package WaveSoftProgram.parts;

import java.util.Arrays;
import java.util.List;

/**
 * Class describes an object of place in the car, where an autopart is broken.
 */
public class PlaceInCar {
    private String nameOfPlace;
    private List<PartCategory> categories;

    public PlaceInCar() {}

    public PlaceInCar(String nameOfPlace, List<PartCategory> categories) {
        this.nameOfPlace = nameOfPlace;
        this.categories = categories;
    }

    /**
     * Standard POJO getter.
     * @return Reference to the name of place in the car, where an autopart is broken.
     */
    public String getNameOfPlace() {
        return nameOfPlace;
    }

    /**
     * Standard POJO getter.
     * @return Reference to the list of categories belong to this place in the car.
     */
    public List<PartCategory> getCategories() {
        return categories;
    }

    /**
     * Standard POJO setter.
     * @param nameOfPlace Sets the name of place in the car, where an autopart is broken.
     */
    public void setNameOfPlace(String nameOfPlace) {
        this.nameOfPlace = nameOfPlace;
    }

    /**
     * Standard POJO setter.
     * @param categories Sets the list of categories belong to this place in the car.
     */
    public void setCategories(List<PartCategory> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "PlaceInCar{" +
                "nameOfPlace='" + nameOfPlace + '\'' +
                ", categories=" + categories +
                '}';
    }
}
