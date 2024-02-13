package docs.Interface;

import docs.classes.Document;

public interface Printable {

    static void printDoc(Document document) {
        System.out.println("Imprimiendo documento: " + document.type);
    }
}
