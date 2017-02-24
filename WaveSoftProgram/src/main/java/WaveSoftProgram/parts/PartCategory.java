package WaveSoftProgram.parts;

import java.util.Arrays;

/**
 * Created by piotr_gy on 22.02.17.
 */
public class PartCategory {
    private String categoryName;
    private Part[] parts;

    public PartCategory(String categoryName, Part[] parts) {
        this.categoryName = categoryName;
        this.parts = parts;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Part[] getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "PartCategory{" +
                "categoryName='" + categoryName + '\'' +
                ", parts=" + Arrays.toString(parts) +
                '}';
    }
}
