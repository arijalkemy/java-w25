package main;

public class Curriculum implements Imprimible{

    private String name;
    private int age;
    private String email;
    private String skillsList;

    public Curriculum(String name, int age, String email, String skillsList) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.skillsList = skillsList;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", skillsList='" + skillsList + '\'' +
                '}');
    }

}
