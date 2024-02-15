public class MediumCircuit extends BaseCategory{

    @Override
    public double calculateRegistrationFee(Participant participant) {
        if (participant.getAge() < 18) {
            return 2000;
        } else {
            return 2300;
        }
    }

    @Override
    public String toString() {
        return "Circuito medio: 5 km por selva, arroyos y barro";
    }
}
