package meliboot;

public class Main {
    public static void main(String[] args) {
        int[] lowTemperatures = Helper.TransposeMatrix(Singleton.Get().GetTemperatures(),0);
        int[] highTemperatures = Helper.TransposeMatrix(Singleton.Get().GetTemperatures(), 1);

        int lowerTemperatureIndex = Helper.GetIndexWithLessValue(lowTemperatures);
        int higherTemperatureIndex = Helper.GetIndexWithHighestValue(highTemperatures);

        final String infoTemperatureMessage = "La %s temperatura la tuvo %s, con %d º C.";

        System.out.println(String.format(infoTemperatureMessage,
                "menor",
                Singleton.Get().Cities()[lowerTemperatureIndex],
                lowTemperatures[lowerTemperatureIndex]));
        System.out.println(String.format(infoTemperatureMessage,
                "mayor",
                Singleton.Get().Cities()[higherTemperatureIndex],
                highTemperatures[higherTemperatureIndex]));

    }
}