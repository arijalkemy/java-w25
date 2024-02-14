package bootcamp.exceptions;

public class TrackerNotFoundException extends Exception {

    public TrackerNotFoundException() {
        super("Tracker not found");
    }
}
