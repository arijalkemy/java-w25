package bootcamp.recapitulacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle("Ford","Fiesta",1000));
        vehicleList.add(new Vehicle("Ford","Focus",1200));
        vehicleList.add(new Vehicle("Ford","Explore",2500));
        vehicleList.add(new Vehicle("Fiat","Uno",500));
        vehicleList.add(new Vehicle("Fiat","Cronos",1000));
        vehicleList.add(new Vehicle("Fiat","Torino",1200));
        vehicleList.add(new Vehicle("Chevrolet","Aveo",1200));
        vehicleList.add(new Vehicle("Chevrolet","Spin",2500));
        vehicleList.add(new Vehicle("Totoya","Corola",1200));
        vehicleList.add(new Vehicle("Totoya","Torino",3000));
        vehicleList.add(new Vehicle("Renault","Logan",950));

        Garage garage = new Garage(1);
        garage.setVehicleList(vehicleList);

        Comparator<Vehicle> comparatorByBranchPrice = Comparator.comparing(Vehicle::getBranch).thenComparing(Vehicle::getPrice);
        Comparator<Vehicle> comparatorByPriceBranch = Comparator.comparing(Vehicle::getPrice).thenComparing(Vehicle::getModel);

        //vehicleList.stream().sorted((x,y)-> (int) (x.getPrice() - y.getPrice())).forEach(System.out::println);
        System.out.println(" ............ " );
        //vehicleList.stream().sorted(comparatorByBranchPrice).forEach(System.out::println);
        vehicleList.stream().sorted(Comparator.comparing(Vehicle::getBranch).thenComparing(Vehicle::getPrice)).forEach(System.out::println);
        System.out.println(" ............ " );
        vehicleList.stream().filter(x->x.getPrice()<1000).forEach(System.out::println);
        System.out.println(" ............ " );
        vehicleList.stream().filter(x->x.getPrice()>1000).forEach(System.out::println);

        System.out.println(" -------- " );
        double avh = vehicleList.stream().mapToDouble(Vehicle::getPrice).average().orElse(0.0);
        System.out.printf("avg %.2f", avh);
    }
}
