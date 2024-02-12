package integracion.p1.general;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Client> clientsList = new ArrayList<>();
        List<Ticket> ticketList = new ArrayList<>();
        clientsList.add( new Client(1234,"Bork","Ednit"));
        clientsList.add( new Client(1233,"Bark","Ednit"));
        clientsList.add( new Client(1232,"Burk","Ednit"));
        
        printClientList(clientsList);
        clientsList.remove(2);
        System.out.println(" ......." );
        printClientList(clientsList);

        findClientByDni(clientsList);

        List<Items> itemsList = new ArrayList<>();
        itemsList.add(new Items(1,"agua", 2,10));
        itemsList.add(new Items(1,"cerea", 1,80));
        itemsList.add(new Items(1,"Nueces", 1,200));
        itemsList.add(new Items(1,"Pan", 2,15));
        
        
        Ticket ticket001 = new Ticket(findOrCreateClient(1235, clientsList), itemsList);

        System.out.println("ticket001 = " + ticket001);


    }

    private static Client findOrCreateClient(int dni, List<Client> clientList){
        Optional<Client> client = clientList.stream().filter(x-> x.getDni() == dni).findFirst();
        if (client.isPresent()){
            return client.get();
        }
        else {
            Client aux = new Client(dni,"Generic","Generic");
            clientList.add(aux);
            return aux;
        }
    }
    private static  void printClientList(List<Client> clients){
        for (Client client : clients){
            System.out.println(client.toString());
        }
    }

    private static void findClientByDni(List<Client> clientList){
        Scanner scanner = new Scanner(System.in);
        int dni = scanner.nextInt();
        Optional<Client> finded = clientList.stream().filter(x-> x.getDni() == dni).findFirst();
        if (finded.isPresent()){
            System.out.println("finded = " + finded.get());
        }else {
            System.out.println(" dni no found " );
        }

    }
}
