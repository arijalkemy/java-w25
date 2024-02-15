public class Vehicle {
    private int speed;
    private int acceleration;
    private double turningAngle;
    private String licensePlate;
    private int weight;
    private int wheels;

    public Vehicle() {
    }

    public Vehicle(int weight, int wheels) {
        this.weight = weight;
        this.wheels = wheels;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public double getTurningAngle() {
        return turningAngle;
    }

    public void setTurningAngle(double turningAngle) {
        this.turningAngle = turningAngle;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
