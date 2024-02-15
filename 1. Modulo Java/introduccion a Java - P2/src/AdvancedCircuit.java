public class AdvancedCircuit extends BaseCategory{
    @Override
    public double calculateRegistrationFee(Participant participant) {
        if (participant.getAge() < 18) {
            throw new IllegalArgumentException("Minors are not allowed to register for the Advanced Circuit.");
        }
        return 2800;
    }

    @Override
    public String toString() {
        return "Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra";
    }
}
