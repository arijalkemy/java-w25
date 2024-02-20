import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Category {
    String name;
    int recorrido;
    String terreno;
    int gt;
    int lte;
    public Category(String nameEntry, int re, String te, int gtEntry, int lteEntry) {
        name = nameEntry;
        recorrido = re;
        terreno = te;
        gt = gtEntry;
        lte = lteEntry;
    }
}

class Participante {
    int id;
    int dni;
    String name;
    String lastName;
    int age;
    int cellphone;
    int emergencies;
    String rh;
    Category category;
    int pay;
//    número de participante, dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo
    public Participante(HashMap<String, Category> categories, String cate, int ide, int dnie , String namee , String lastNamee , int agee , int cellphonee , int emergenciese , String rhe) {
        id = ide;
        dni = dnie;
        name = namee;
        lastName = lastNamee;
        age = agee;
        cellphone = cellphonee;
        emergencies = emergenciese;
        rh = rhe;
        category = categories.get(cate);

        if (agee <= 18) {
            pay = categories.get(cate).lte;
        } else {
            pay = categories.get(cate).gt;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HashMap<String, Category> categories = new HashMap<String, Category>();
        categories.put("cc", new Category("cc",2, "selva y arroyos", 1500, 1300));
        categories.put("cm", new Category("cm",5, "selva, arroyos y barro", 2300, 2000));
        categories.put("ca", new Category("ca",10, "selva, arroyos, barro y escalada en piedra", 2800, 0));
        List<Participante> participantes = new ArrayList<Participante>();
        participantes.add(new Participante(categories, "cc", 1, 1, "juan", "toro", 21, 123, 1234, "b+"));
        participantes.add(new Participante(categories, "cm", 2, 2, "Alberto", "Mejia", 17, 1233, 1233, "a+"));
        participantes.add(new Participante(categories, "ca", 3, 3, "Julio", "Arriola", 25, 12312, 1234123, "o-"));
        for (Participante part : participantes) {
            System.out.println("Pago: " + part.pay + ", categoria: " + part.category.name + ", pay: " + part.pay);
        }
    }
}