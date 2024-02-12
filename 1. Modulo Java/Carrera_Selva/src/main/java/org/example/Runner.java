package org.example;
import  lombok.Data;

@Data
public class Runner {
    int runnerNumber;
    int dni;
    String name;
    String lastName;
    int age;
    String phoneNumber;
    String emergencyNumber;
    String bloodType;
    Circuito circuito = new Circuito();

    public void subscribeCompetition(int category){
        this.circuito.category =  (this.age < 18 && category == 3 ) ? 0: category;
        if (age < 18){
            switch (category){
                case 1:
                    this.circuito.price=1300;
                    break;
                case 2:
                    this.circuito.price=2000;
                    break;
                default:
                    this.circuito.price=0;
                    break;
            }
        }else{
            switch (category){
                case 1:
                    this.circuito.price=1500;
                    break;
                case 2:
                    this.circuito.price=2300;
                    break;
                default:
                    this.circuito.price=2800;
                    break;
            }
        }

    }

}
