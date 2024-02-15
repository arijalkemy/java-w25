public class Participant {
    private int participantNumber;
    private String dni;
    private String name;
    private String surname;
    private int age;
    private String phone;
    private String emergencyNumber;
    private String bloodGroup;

    public Participant(int participantNumber, String dni, String name, String surname, int age, String phone, String emergencyNumber, String bloodGroup) {
        this.participantNumber = participantNumber;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.emergencyNumber = emergencyNumber;
        this.bloodGroup = bloodGroup;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(int participantNumber) {
        this.participantNumber = participantNumber;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
