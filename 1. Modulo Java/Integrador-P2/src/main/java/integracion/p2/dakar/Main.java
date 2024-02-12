package integracion.p2.dakar;

import integracion.p2.dakar.base.*;

public class Main {
    public static void main(String[] args) {
        Cars vocho1 = new Cars(80,3.5, 10,"HH22");
        Cars vocho2 = new Cars(79,3.6, 13,"HH23");
        Cars vocho3 = new Cars(82,3.4, 12,"HH24");

        Motorcycle moto1 = new Motorcycle(90,2.3,23,"MM00");
        Motorcycle moto2 = new Motorcycle(93,2.3,14,"MM01");

        Competition rally = new Competition(120,10000, "El quilonbo", 3);

        rally.signupCar(vocho1.getSpeed(), vocho1.getAcceleration(), vocho1.getTurnAngle(), vocho1.getPatent());
        rally.signupCar(vocho2.getSpeed(), vocho2.getAcceleration(), vocho2.getTurnAngle(), vocho2.getPatent());
        rally.signupMotorcycle(moto1.getSpeed(), moto1.getAcceleration(), moto1.getTurnAngle(), moto1.getPatent());
        rally.signupCar(vocho3.getSpeed(), vocho3.getAcceleration(), vocho3.getTurnAngle(), vocho3.getPatent());

        rally.removeVehicle(vocho1);
        rally.signupCar(vocho3.getSpeed(), vocho3.getAcceleration(), vocho3.getTurnAngle(), vocho3.getPatent());
        rally.removeVehicleByPatent("MM00");
        rally.signupCar(moto2.getSpeed(), moto2.getAcceleration(), moto2.getTurnAngle(), moto2.getPatent());
        System.out.println("rally.getVehicleList() = " + rally.getVehicleList());

        rally.getWinner();

        LiveguardMoto liveguardMoto = new LiveguardMoto();
        LifeguardCar lifeguardCar = new LifeguardCar();

        lifeguardCar.giveHelp(vocho1);
        liveguardMoto.giveHelp(moto2);

        rally.giveHelpCar("HH24");
        rally.giveHelpMoto("MM01");

    }
}
