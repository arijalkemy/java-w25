package docs;

import docs.Interface.Printable;
import docs.classes.Book;
import docs.classes.Curriculum;
import docs.classes.Inform;

import java.util.ArrayList;

public class DocumentMain {
    public static void main(String[] args) {
        Book cuento = new Book(50, "Pepito","Aventuras de pepito", "Accion");
        Printable.printDoc(cuento);
        Curriculum cvPepe = new Curriculum("Pepe", 15, "Carpintero", new ArrayList<>());
        Printable.printDoc(cvPepe);
        Inform newInform = new Inform(50, 30, "Pepito", "Andres");
        Printable.printDoc(newInform);
    }
}
