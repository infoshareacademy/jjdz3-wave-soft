package WaveSoftProgram.parts;

import java.util.Arrays;

/**
 * Created by piotr_gy on 22.02.17.
 */
public class PlaceInCar {
    private String nameOfPlace;
    private PartCategory[] categories;

    public PlaceInCar(String nameOfPlace, PartCategory[] categories) {
        this.nameOfPlace = nameOfPlace;
        this.categories = categories;
    }

    public String getNameOfPlace() {
        return nameOfPlace;
    }

    public PartCategory[] getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "PlaceInCar{" +
                "nameOfPlace='" + nameOfPlace + '\'' +
                ", categories=" + Arrays.toString(categories) +
                '}';
    }
}
