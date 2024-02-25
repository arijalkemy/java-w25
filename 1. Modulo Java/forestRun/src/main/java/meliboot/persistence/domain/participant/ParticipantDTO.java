package meliboot.persistence.domain.participant;


import meliboot.services.enums.EnumBloodGroup;

public record ParticipantDTO(int participantNumber,
                             long dni,
                             String name,
                             String lastName,
                             short age,
                             long phoneNumber,
                             long emergencyNumber,
                             EnumBloodGroup bloodGroup){

    public EnumBloodGroup getBloodGroup(){ return  this.getBloodGroup(); }

}
