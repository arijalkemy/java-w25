public class Main {
    public static void main(String[] args) {
        Race dakarRace = new Race();
        dakarRace.setName("Dakar");
        dakarRace.setDistance(5000);
        dakarRace.setPrizeInDollars(1000000);
        dakarRace.setAllowedVehiclesNumber(10);

        // Registro de vehículos
        dakarRace.signUpCar(150, 10, 45, "CAR001");
        dakarRace.signUpCar(130, 15, 30, "CAR002");
        dakarRace.signUpMotorcycle(180, 20, 60, "MOTO001");
        dakarRace.signUpMotorcycle(160, 25, 55, "MOTO002");

        // Intentar eliminar un vehículo que no existe
        dakarRace.removeVehicleByLicensePlate("CAR999");
        // No hace nada, el vehículo no existe

        // Eliminar un vehículo existente
        dakarRace.removeVehicleByLicensePlate("CAR002");

        // Determinar el ganador
        Vehicle winner = dakarRace.determineWinner();
        System.out.println("El ganador es el vehículo con patente: " + winner.getLicensePlate());

        // Instanciar socorristas
        dakarRace.setRescueCar(new RescueCar());
        dakarRace.setRescueMotorcycle(new RescueMotorcycle());

        // Socorrer a un auto y una moto
        dakarRace.rescueCar("CAR001");
        dakarRace.rescueMotorcycle("MOTO001");
    }
}