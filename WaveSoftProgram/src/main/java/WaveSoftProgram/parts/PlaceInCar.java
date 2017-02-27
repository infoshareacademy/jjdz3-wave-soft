package WaveSoftProgram.parts;

import java.util.Arrays;
import java.util.List;

/**
 * Created by piotr_gy on 22.02.17.
 */
public class PlaceInCar {
    private String nameOfPlace;
    private List<PartCategory> categories;

    public PlaceInCar() {}

    public PlaceInCar(String nameOfPlace, List<PartCategory> categories) {
        this.nameOfPlace = nameOfPlace;
        this.categories = categories;
    }

    public String getNameOfPlace() {
        return nameOfPlace;
    }

    public List<PartCategory> getCategories() {
        return categories;
    }

    public void setNameOfPlace(String nameOfPlace) {
        this.nameOfPlace = nameOfPlace;
    }

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
