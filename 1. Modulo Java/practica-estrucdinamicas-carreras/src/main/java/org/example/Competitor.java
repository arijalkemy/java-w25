package org.example;

public class Competitor {

    public Competitor (int competitorId, int dni, String firstname, String lastname, int age, int cellPhone,
                       int emergencyNumber, String bloodType){
        this.competitorId = competitorId;
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.cellPhone = cellPhone;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    public Competitor() {
    }

    private int competitorId;
    private int dni;
    private String firstname;
    private String lastname;
    private int age;
    private int cellPhone;
    private int emergencyNumber;
    private String bloodType;

    public int getCompetitorId() {
        return competitorId;
    }

    public void setCompetitorId(int competitorId) {
        this.competitorId = competitorId;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(int cellPhone) {
        this.cellPhone = cellPhone;
    }

    public int getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(int emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "competitorId=" + competitorId +
                ", dni=" + dni +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", cellPhone=" + cellPhone +
                ", emergencyNumber=" + emergencyNumber +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
