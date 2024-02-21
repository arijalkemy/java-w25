public class App {
    public static void main(String[] args) throws Exception {
        String[] cityes = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        Integer[][] tempMatrix = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        Integer minTemp=Integer.MAX_VALUE;
        Integer maxTemp=Integer.MIN_VALUE;
        Integer minIndex = 0;
        Integer maxIndex = 0;
        
        for(int i=0;i<tempMatrix.length;i++){
            for(int j=0;j<tempMatrix[i].length;j++){
                if(minTemp>tempMatrix[i][j]){
                    minTemp=tempMatrix[i][j];
                    minIndex=i;
                }
                if(maxTemp<tempMatrix[i][j]){
                    maxTemp=tempMatrix[i][j];
                    maxIndex=i;
                }
            }
        }

        System.out.println("La ciudad de "+cityes[minIndex]+" llego a una temperatura minima de "+tempMatrix[minIndex][0]+"°C que supera a las minimas de las demas ciudades!");
        System.out.println("La ciudad de "+cityes[maxIndex]+" llego a una temperatura maxima de "+tempMatrix[maxIndex][1]+"°C que supera a las maximas de las demas ciudades!");
    }
}
