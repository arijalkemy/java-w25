package bootcamp.interfaz.ejercicio2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Edg", "Med" , 33);
        List<Skills> skills = List.of(new Skills("java", "mediom"),
            new Skills("python","Basic"));

        IPrintable resume = new Resume(person, skills);
        IPrintable pdf= new Pdf(10,"Bork","How to teach java to your cat", "IT");
        IPrintable info = new Infos("Posum loren ok thats enoguh", 34,"jac","edg");

        resume.printFile();
        pdf.printFile();
        info.printFile();
    }
}
