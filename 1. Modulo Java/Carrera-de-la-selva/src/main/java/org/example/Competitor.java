package org.example;

public class Competitor {
    private int id;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String phone;
    private String emergencyNumber;
    private String rh;

    public Competitor() {
    }

    public Competitor(int id, String dni, String name, String lastName, int age, String phone, String emergencyNumber, String rh) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.emergencyNumber = emergencyNumber;
        this.rh = rh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }
}
