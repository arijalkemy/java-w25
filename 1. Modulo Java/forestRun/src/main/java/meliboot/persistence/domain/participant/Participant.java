package meliboot.persistence.domain.participant;

import meliboot.services.enums.EnumBloodGroup;

public class Participant {
    private int participantNumber;
    private long dni;
    private String name;
    private String lastName;
    private short age;
    private long phoneNumber;
    private long emergencyNumber;
    private EnumBloodGroup bloodGroup;

    public Participant(
            int participantNumber,
            long dni,
            String name,
            String lastName,
            short age,
            long phoneNumber,
            long emergencyNumber,
            EnumBloodGroup bloodGroup)
    {
        this.participantNumber = participantNumber;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emergencyNumber = emergencyNumber;
        this.bloodGroup = bloodGroup;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public long getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public short getAge() {
        return age;
    }

    @Override
    public String toString(){
        return String.format("Name %s Participant Number %d Age %d",this.name,this.participantNumber,this.age);
    }
}
