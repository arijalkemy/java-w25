package meliboot;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Localizator fullPackage = new Localizator(
                new Client(1),
                new AdditionalServices(2,3,2),
                Arrays.asList(new Reservation())
        );
        Localizator fullWithReservationsTwo = new Localizator(
                new Client(1),
                new AdditionalServices(2,2,2),
                Arrays.asList(
                        new Reservation(),
                        new Reservation()
                )
        );
        Localizator fullWithReservationsOne = new Localizator(
                new Client(1),
                new AdditionalServices(2,2,2),
                Arrays.asList(
                        new Reservation()
                )
        );
        LocalizatorRepository.getInstance().Add(fullPackage);
        System.out.println(fullPackage);
        LocalizatorRepository.getInstance().Add(fullWithReservationsOne);
        System.out.println(fullWithReservationsTwo);
        LocalizatorRepository.getInstance().Add(fullWithReservationsTwo);
        System.out.println(fullWithReservationsOne);

    }
}