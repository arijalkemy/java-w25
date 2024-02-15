public class Registration {
    private Participant participant;
    private double fee;

    public Registration(Participant participant, double fee) {
        this.participant = participant;
        this.fee = fee;
    }

    public Participant getParticipant() {
        return participant;
    }

    public double getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "participantNumber=" + participant.getParticipantNumber() +
                ", name=" + participant.getName() +
                ", fee=" + fee +
                '}';
    }
}
