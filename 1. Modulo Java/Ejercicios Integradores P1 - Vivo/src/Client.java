import java.util.ArrayList;
import java.util.List;

public class Client {
    String name;
    List<Locator> locators = new ArrayList<>();

    public Client(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}
