public class Participant {
    private int id;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String mobilePhone;
    private String emergencyPhone;
    private String bloodGroup;

    private int generateId(){
        return (int) (Math.floor(Math.random()*(99999999-10000000+1)+10000000));
    }

    public Participant(){
        this.id = generateId();
    }

    public Participant(String dni, String name, String lastName, int age, String mobilePhone, String emergencyPhone, String bloodGroup) {
        this.id = generateId();
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.mobilePhone = mobilePhone;
        this.emergencyPhone = emergencyPhone;
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }


}
