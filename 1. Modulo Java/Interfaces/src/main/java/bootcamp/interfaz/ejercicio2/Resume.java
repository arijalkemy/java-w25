package bootcamp.interfaz.ejercicio2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Resume implements  IPrintable{
    Person person;
    List<Skills> skills;


    @Override
    public void printFile() {
        System.out.println(
                "printing :" + '\n' +
                        person + '\n' +
                        skills    );
    }
}
