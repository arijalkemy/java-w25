package bootcamp.interfaz.ejercicio2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pdf implements  IPrintable {
    private int pages;
    private String author;
    private String title;
    private String category;

    @Override
    public void printFile() {
        System.out.println(
                "printing :" + '\n' +
                        "title='" + title + '\n' +
                        "pages=" + pages + '\n' +
                        "author='" + author + '\n'+
                        "category='" + category );
    }
}
