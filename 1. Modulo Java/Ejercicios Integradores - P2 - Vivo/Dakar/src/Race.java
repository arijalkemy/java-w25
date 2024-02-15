import java.util.ArrayList;
import java.util.List;

public class Race {
    private double distance;
    private double prizeInDollars;
    private String name;
    private int allowedVehiclesNumber;
    private List<Vehicle> vehicles = new ArrayList<>();

    private RescueCar rescueCar;
    private RescueMotorcycle rescueMotorcycle;

    public Race() {
    }

    public Race(double distance, double prizeInDollars, String name, int allowedVehiclesNumber, List<Vehicle> vehicles) {
        this.distance = distance;
        this.prizeInDollars = prizeInDollars;
        this.name = name;
        this.allowedVehiclesNumber = allowedVehiclesNumber;
        this.vehicles = vehicles;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrizeInDollars() {
        return prizeInDollars;
    }

    public void setPrizeInDollars(double prizeInDollars) {
        this.prizeInDollars = prizeInDollars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllowedVehiclesNumber() {
        return allowedVehiclesNumber;
    }

    public void setAllowedVehiclesNumber(int allowedVehiclesNumber) {
        this.allowedVehiclesNumber = allowedVehiclesNumber;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void signUpCar(int speed, int acceleration, double turningAngle, String licensePlate) {
        if (this.vehicles.size() < this.allowedVehiclesNumber) {
            Car car = new Car();
            car.setSpeed(speed);
            car.setAcceleration(acceleration);
            car.setTurningAngle(turningAngle);
            car.setLicensePlate(licensePlate);
            this.vehicles.add(car);
        }
    }

    public void signUpMotorcycle(int speed, int acceleration, double turningAngle, String licensePlate) {
        if (this.vehicles.size() < this.allowedVehiclesNumber) {
            Motorcycle motorcycle = new Motorcycle();
            motorcycle.setSpeed(speed);
            motorcycle.setAcceleration(acceleration);
            motorcycle.setTurningAngle(turningAngle);
            motorcycle.setLicensePlate(licensePlate);
            this.vehicles.add(motorcycle);
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public void removeVehicleByLicensePlate(String licensePlate) {
        this.vehicles.removeIf(v -> v.getLicensePlate().equals(licensePlate));
    }

    public Vehicle determineWinner() {
        Vehicle winner = null;
        double maxScore = 0;

        for (Vehicle v : this.vehicles) {
            double score = v.getSpeed() * 0.5 * v.getAcceleration() / (v.getTurningAngle() * (v.getWeight() - v.getWheels() * 100));
            if (score > maxScore) {
                maxScore = score;
                winner = v;
            }
        }

        return winner;
    }

    public void rescueCar(String licensePlate) {
        for (Vehicle v : vehicles) {
            if (v instanceof Car && v.getLicensePlate().equals(licensePlate)) {
                this.rescueCar.rescue((Car) v);
                break;
            }
        }
    }

    public void rescueMotorcycle(String licensePlate) {
        for (Vehicle v : vehicles) {
            if (v instanceof Motorcycle && v.getLicensePlate().equals(licensePlate)) {
                this.rescueMotorcycle.rescue((Motorcycle) v);
                break;
            }
        }
    }

    public RescueCar getRescueCar() {
        return rescueCar;
    }

    public void setRescueCar(RescueCar rescueCar) {
        this.rescueCar = rescueCar;
    }

    public RescueMotorcycle getRescueMotorcycle() {
        return rescueMotorcycle;
    }

    public void setRescueMotorcycle(RescueMotorcycle rescueMotorcycle) {
        this.rescueMotorcycle = rescueMotorcycle;
    }
}
