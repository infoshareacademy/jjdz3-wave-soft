package WaveSoftProgram.parts;

/**
 * Created by piotr_gy on 22.02.17.
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

    public String getPartId() {
        return partId;
    }

    public String getSearchPhrase() {
        return searchPhrase;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

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
