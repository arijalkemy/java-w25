import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    List<Client> clients = new ArrayList<>();
    public Client getOrRegisterClient(String name) {
        return clients.stream()
                .filter(c -> c.name.equals(name))
                .findFirst()
                .orElseGet(() -> {
                    Client newClient = new Client(name);
                    clients.add(newClient);
                    return newClient;
                });
    }
}
