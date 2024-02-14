package bootcamp.dtoresponseentityp2.model;

public enum Severity {
    LOW("Baja"),
    MEDIUM("Media"),
    HIGH("Alta"),
    CRITICAL("Crítica");

    public final String severity;
    private Severity(String severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return severity;
    }
}
