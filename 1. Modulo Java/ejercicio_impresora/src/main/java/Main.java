import entity.*;
import service.IPrintable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        skills.add("HTML");
        skills.add("CSS");
        skills.add("JavaScript");

        List<String> experience = new ArrayList<>();
        experience.add("Software Developer Intern");
        experience.add("Web Designer");
        experience.add("Data Analyst");
        experience.add("Project Manager");
        experience.add("Quality Assurance Tester");

        Person person = new Person(skills, experience);

        Curriculum curriculum = new Curriculum(person);

        IPrintable.print(curriculum);

        Book book = new Book(243, "Edgar Allan Poe", "La caida de la casa de usher", "terror");
        Pdf pdf = new Pdf(book);

        IPrintable.print(pdf);

        Report report = new Report("kawkjfkjwafblkabwfbakjfwbabwf", 1, "Vicente", "Lopez");

        IPrintable.print(report);
    }
}
