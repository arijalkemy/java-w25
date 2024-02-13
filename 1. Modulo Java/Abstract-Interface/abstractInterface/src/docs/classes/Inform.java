package docs.classes;

import docs.classes.Document;

public class Inform extends Document {

    private Integer informLength;
    private Integer pagesCount;
    private String author;
    private String reviser;

    public Inform(Integer informLength, Integer pagesCount, String author, String reviser) {
        this.informLength = informLength;
        this.pagesCount = pagesCount;
        this.author = author;
        this.reviser = reviser;
        type = "Informe";
    }
}
