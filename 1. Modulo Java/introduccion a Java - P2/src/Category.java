public interface Category {
    void registerParticipant(Participant participant);
    void unregisterParticipant(int idParticipant);

    void showParticipants();

    double calculateRegistrationFee(Participant participant);

    double calculateTotalCollected();

}
