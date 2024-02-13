package org.example;

public class Participant{
    int partNumber;
    int dni;
    String name;
    String lastName;
    int age;
    int phoneNumber;
    int emergencyNumber;
    String rh;

    public Participant(int partNumber, int dni, String name, String lastName, int age, int phoneNumber, int emergencyNumber, String rh) {
        this.partNumber = partNumber;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emergencyNumber = emergencyNumber;
        this.rh = rh;
    }

    public Integer getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public String toString() {
        return "Número de participante: " + partNumber + ", DNI: " + dni +
                ", Nombre: " + name + ", Apellido: " + lastName + ", Edad: " + age;
    }
}
