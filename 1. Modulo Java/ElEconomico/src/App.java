// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.NoSuchElementException;
// import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        DbClients dbClients = new DbClients();
        dbClients.create(new Client(12345678L, "Ricardo", "Electrico"));
        dbClients.create(new Client(87654321L, "Jose", "Enchufe"));
        dbClients.create(new Client(43215678L, "Dario", "Electricidad"));

        dbClients.read();
        Client c = dbClients.readById(1L);
        c.setName("Pepe");
        c.setLastname("Piedra");
        dbClients.update(c);
        dbClients.delete(2L);
        dbClients.read();
        // List<Client> clients = new ArrayList<>(Arrays.asList(
        //     new Client(12345678L, "Ricardo", "Electrico"),
        //     new Client(87654321L, "Jose", "Enchufe"),
        //     new Client(43215678L, "Dario", "Electricidad")));

        // List<Invoice> invoices = new ArrayList<>();

        // for(Client c:clients){
        //     System.out.println(c.toString());
        // }

        // System.out.println("-------------------------");

        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Ingresa dni del cliente a borrar: ");
        // try {
        //     Long dni = scanner.nextLong();
        //     scanner.nextLine();
        //     Client client = clients.stream().filter(c -> c.getDni().equals(dni)).findFirst().orElseThrow();
        //     clients.remove(client);
        //     System.out.println("Cliente borrado con exito.");
        // } catch (NoSuchElementException e) {
        //     System.out.println("Cliente no encontrado.");
        // }

        // System.out.println("-------------------------");

        // System.out.print("Ingresa dni del cliente a buscar: ");
        // try {
        //     Long dni = scanner.nextLong();
        //     scanner.nextLine();
        //     Client client = clients.stream().filter(c -> c.getDni().equals(dni)).findFirst().orElseThrow();
        //     System.out.println("Datos del cliente: "+client.toString());
        // } catch (NoSuchElementException e) {
        //     System.out.println("Cliente no encontrado.");
        // }

        // scanner.close();

        // for(Client c:clients){
        //     System.out.println(c.toString());
        // }
        
        // Client client = new Client(12093487L, "Arnold", "Boshka");
        // Invoice invoice1 = new Invoice(client, Arrays.asList(new Item(1, "Shampoo", 300D),new Item(2, "Jabon", 150D), new Item(3, "Toalla", 500D)));

        // if(!clients.stream().filter(c -> c.equals(client)).findFirst().isPresent()){
        //     clients.add(client);
        // }
        // invoices.add(invoice1);
        // System.out.println(invoice1.toString());

    }
}
