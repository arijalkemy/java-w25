import java.util.ArrayList;
import java.util.List;

public class DbClients implements IOperations<Client> {

    private static List<Client> clients = new ArrayList<>();
    @Override
    public void create(Client client) {
        clients.add(client);
    }

    @Override
    public void update(Client updatedClient) {
        Integer index = clients.indexOf(clients.stream().filter(c -> c.getId().equals(updatedClient.getId())).findFirst().orElseThrow());
        clients.set(index, updatedClient);
    }

    @Override
    public void read() {
        for(Client c:clients){
            System.out.println(c.toString());
        }
    }

    @Override
    public void delete(Long id) {
        clients.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public Client readById(Long id) {
        return clients.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow();
    }
}
