import java.util.ArrayList;
import java.util.List;

public abstract class BaseCategory implements Category {
    protected List<Registration> registrations = new ArrayList<>();

    @Override
    public void registerParticipant(Participant participant) {
        Registration registration = new Registration(participant, this.calculateRegistrationFee(participant));
        registrations.add(registration);
        System.out.println("Participante registrado: " + registration.toString());
    }

    @Override
    public void unregisterParticipant(int idParticipant) {
        registrations.removeIf(registration -> registration.getParticipant().getParticipantNumber() == idParticipant);
        System.out.println("Participante desinscrito: " + idParticipant);
    }

    @Override
    public void showParticipants() {
        for(Registration registration : registrations) {
            System.out.println(registration);
        }
    }

    @Override
    public abstract double calculateRegistrationFee(Participant participant);

    @Override
    public double calculateTotalCollected() {
        double total = 0;
        for (Registration registration : registrations) {
            total += registration.getFee();
        }
        return total;
    }
}
