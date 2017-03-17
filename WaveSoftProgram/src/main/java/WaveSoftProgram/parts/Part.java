package WaveSoftProgram.parts;

/**
 * Class describes an object of an autopart.
 */
public class Part {
    private String partId;
    private String searchPhrase;

    public Part() {
    }

    public Part(String partId, String searchPhrase) {
        this.partId = partId;
        this.searchPhrase = searchPhrase;
    }

    /**
     * Standard POJO getter.
     * @return Reference to the name of an autopart.
     */
    public String getPartId() {
        return partId;
    }

    /**
     * Standard POJO getter.
     * @return Reference to the searching phrase of an autopart.
     */
    public String getSearchPhrase() {
        return searchPhrase;
    }

    /**
     * Standard POJO setter.
     * @param partId Sets the name of an autopart.
     */
    public void setPartId(String partId) {
        this.partId = partId;
    }

    /**
     * Standard POJO setter.
     * @param searchPhrase Sets the searching phrase of an autopart.
     */
    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    @Override
    public String toString() {
        return "Part{" +
                "partId='" + partId + '\'' +
                ", searchPhrase='" + searchPhrase + '\'' +
                '}';
    }
}
