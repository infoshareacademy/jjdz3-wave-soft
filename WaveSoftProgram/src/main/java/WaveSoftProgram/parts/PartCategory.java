package WaveSoftProgram.parts;

import java.util.Arrays;
import java.util.List;

/**
 * Created by piotr_gy on 22.02.17.
 */
public class PartCategory {
    private String categoryName;
    private List <Part> parts;

    public PartCategory(String categoryName, List <Part> parts) {
        this.categoryName = categoryName;
        this.parts = parts;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List <Part> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "PartCategory{" +
                "categoryName='" + categoryName + '\'' +
                ", parts=" + parts +
                '}';
    }
}
