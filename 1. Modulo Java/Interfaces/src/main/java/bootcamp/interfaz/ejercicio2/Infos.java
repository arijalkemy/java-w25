package bootcamp.interfaz.ejercicio2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Infos implements  IPrintable{

    private String text;
    private int pages;
    private String author;
    private String reviewer;
    @Override
    public void printFile() {
        System.out.println(
                "printing :" + '\n' +
                "text='" + text + '\n' +
                "pages=" + pages + '\n' +
                "author='" + author + '\n'+
                "reviewer='" + reviewer );
    }


}
