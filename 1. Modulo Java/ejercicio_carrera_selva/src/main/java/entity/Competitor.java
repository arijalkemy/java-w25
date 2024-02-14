package entity;

import java.util.Objects;

public class Competitor {
    private String num;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private int phone;
    private int emergencyPhone;
    private String bloodType;

    public Competitor(String num, String dni, String name, String lastName, int age, int phone, int emergencyPhone, String bloodType) {
        this.num = num;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "num='" + num + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", emergencyPhone=" + emergencyPhone +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Competitor that = (Competitor)obj;
        return Objects.equals(num, that.num);
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(int emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
