package bootcamp.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Client extends GenericObject {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private String firstName;
    private String lastName;

    public Client(String firstName, String lastName) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
