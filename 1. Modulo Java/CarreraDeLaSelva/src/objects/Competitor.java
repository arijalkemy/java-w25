package objects;

public class Competitor {
    private Integer competitorId;
    private Integer dni;
    private String name;
    private String lastname;
    private Integer age;
    private Integer phone;
    private Integer emergencyPhone;
    private String bloodType;
    
    public Competitor(Integer competitorId, Integer dni, String name, String lastname, Integer age, Integer phone,
            Integer emergencyPhone, String bloodType) {
        this.competitorId = competitorId;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.bloodType = bloodType;
    }

    public Integer getCompetitorId() {
        return competitorId;
    }
    public void setCompetitorId(Integer competitorId) {
        this.competitorId = competitorId;
    }
    public Integer getDni() {
        return dni;
    }
    public void setDni(Integer dni) {
        this.dni = dni;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public Integer getEmergencyPhone() {
        return emergencyPhone;
    }
    public void setEmergencyPhone(Integer emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }
    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
