import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private static final List<Client> clients = new ArrayList<>();

    public static void addClient(Client client){
        clients.add(client);
    }

    public static List<Client> getClients(){
        return clients;
    }
}
