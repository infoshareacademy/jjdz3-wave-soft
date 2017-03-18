package WaveSoftProgram.parts;

import java.util.Arrays;
import java.util.List;

/**
 * Class describes an object of category of an autopart.
 */
public class PartCategory {
    private String categoryName;
    private List <Part> parts;

    public PartCategory() {}

    public PartCategory(String categoryName, List <Part> parts) {
        this.categoryName = categoryName;
        this.parts = parts;
    }

    /**
     * Standard POJO getter.
     * @return Reference to the name of category of an autopart.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Standard POJO getter.
     * @return Reference to the list of this autopart's category.
     */
    public List <Part> getParts() {
        return parts;
    }

    /**
     * Standard POJO setter.
     * @param categoryName Sets the name of category of an autopart.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Standard POJO setter.
     * @param parts Sets the list of this autopart's category.
     */
    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "PartCategory{" +
                "categoryName='" + categoryName + '\'' +
                ", parts=" + parts +
                '}';
    }
}
