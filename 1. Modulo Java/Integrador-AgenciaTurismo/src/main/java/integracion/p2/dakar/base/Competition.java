package integracion.p2.dakar.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Competition {
    private double distant;
    private double price;
    private String name;
    private int maxVehiclesAllow;
    private List<Vehicle> vehicleList;

    public Competition(double distant, double price, String name, int maxVehiclesAllow) {
        this.distant = distant;
        this.price = price;
        this.name = name;
        this.maxVehiclesAllow = maxVehiclesAllow;
        this.vehicleList = new ArrayList<>();
    }

    public void signupCar(double speed, double acceleration, double turnAngel, String patent) {
        if (this.vehicleList.size() < maxVehiclesAllow) {
            vehicleList.add(new Cars(speed, acceleration, turnAngel, patent));
            System.out.println(" Signed up successfully ");
        } else {
            System.out.println(" Competition is full ");
        }
    }
    public void signupMotorcycle(double speed, double acceleration, double turnAngel, String patent){
        if (this.vehicleList.size() < maxVehiclesAllow){
            vehicleList.add(new Motorcycle(speed,acceleration,turnAngel,patent));
            System.out.println(" Signed up successfully " );
        }else {
            System.out.println(" Competition is full " );
        }
    }

    public void removeVehicle(Vehicle vehicle){
        vehicleList.remove(vehicle);
    }

    public void removeVehicleByPatent(String patent){
        this.vehicleList = this.vehicleList.stream().filter(x-> x.getPatent().compareToIgnoreCase(patent) != 0 ).toList();
    }

    public void getWinner(){
        Optional<Vehicle> winner = this.vehicleList.stream().sorted((a,b)-> (int) ((int) calculatePermormance(a) - calculatePermormance(b))).limit(vehicleList.size()-1).findFirst();
        winner.ifPresent(vehicle -> System.out.println("winner = " + vehicle));
    }

    private double calculatePermormance(Vehicle vehicle){
        return  vehicle.getSpeed()*0.5*vehicle.getAcceleration()/(vehicle.getTurnAngle()*(vehicle.getWeigth()-vehicle.getWheels()*100));
    }
}
