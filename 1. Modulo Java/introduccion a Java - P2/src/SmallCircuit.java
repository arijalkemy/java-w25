public class SmallCircuit extends BaseCategory{
    @Override
    public double calculateRegistrationFee(Participant participant) {
        if (participant.getAge() < 18) {
            return 1300;
        } else {
            return 1500;
        }
    }

    @Override
    public String toString() {
        return "Circuito chico: 2 km por selva y arroyos";
    }
}
