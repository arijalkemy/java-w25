package org.example;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    private  String name;
    private int age;
    private String dni;
    private double weigth;
    private double height;
    private double mci;


    public Persona(){ }

    public Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Persona(String name, int age, String dni, double weigth, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weigth = weigth;
        this.height = height;
    }

    public int getIMC(){
        this.mci = this.height <0 ? 0 :this.weigth / this.height*this.height;
        if (mci < 20){
            return -1;
        }
        else if (mci>=20 && mci <= 25) {
            return  0;
        }
        else{
            return 1;
        }
    }

    public boolean isOlder() {
        return age > 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weigth=" + weigth +
                ", height=" + height +
                '}';
    }
}
