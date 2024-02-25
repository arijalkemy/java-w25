package meliboot;

import java.util.Arrays;

public class Singleton {
    private String[] cities = new String[]{"Londres","Madrid","Nueva York","Buenos Aires", "Asunción",
            "São Paulo", "Lima","Santiago de Chile","Lisboa","Tokio"};
    private int[][] temperatures = {{-2,33},{-3,32},{-8,27}, {4,37}, {6,42}, {5,43},{0,39},{-7,26},{-1,31},{-10,35}};

    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton Get(){
        return instance;
    }

    public String[] Cities(){
        return Arrays.copyOf(this.cities,this.cities.length);
    }

    public int[][] GetTemperatures(){
        return Arrays.copyOf(this.temperatures,this.temperatures.length);
    }
}
