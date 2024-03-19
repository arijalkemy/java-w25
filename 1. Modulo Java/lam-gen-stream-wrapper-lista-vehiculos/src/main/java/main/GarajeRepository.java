package main;

import java.util.List;

public class GarajeRepository {

    private List<Garaje> garajeList;

    public GarajeRepository(List<Garaje> garajeList) {
        this.garajeList = garajeList;
    }

    public List<Garaje> getGarajeList() {
        return garajeList;
    }

    public void setGarajeList(List<Garaje> garajeList) {
        this.garajeList = garajeList;
    }
}
