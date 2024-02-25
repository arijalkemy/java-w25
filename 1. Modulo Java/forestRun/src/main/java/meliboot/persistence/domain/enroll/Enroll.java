package meliboot.persistence.domain.enroll;


import meliboot.persistence.domain.participant.Participant;
import meliboot.services.common.classes.AbsCategory;

public class Enroll {
    private int enrollNumber;
    private AbsCategory category;
    private Participant participant;
    private int amountPayable;

    public Enroll(Participant participant, AbsCategory category,int enrollNumber){
        this.participant = participant;
        this.category = category;
        this.toCalculeAmountPayable();
        this.enrollNumber = enrollNumber;
    }

    private void toCalculeAmountPayable(){
        this.amountPayable = switch (this.category.GetType()){
            case SMALL -> this.participant.getAge() < 18?1300:1500;
            case MIDDLE -> this.participant.getAge() < 18?2000:2300;
            case HIGHT -> this.participant.getAge() < 18?-1:2800;
        };
        if(this.amountPayable == -1){
            throw new Error("Menores de 18 años no se pueden inscribir a "+this.category.GetName() );
        }
    }

    public boolean isTheSameParticipantInTheSameCategory(Enroll enroll){
        return enroll.participant.getDni() == this.participant.getDni() && enroll.category == this.category;
    }

    public AbsCategory getCategory() {
        return this.category;
    }

    public int getEnrollNumber(){return this.enrollNumber;}

    public int getAmountPayable() {return this.amountPayable;}

    @Override
    public String toString(){
        return String.format(" EnrollNumber: %s Payable %s Participant %s",this.enrollNumber,this.amountPayable,this.participant);
    }
}
