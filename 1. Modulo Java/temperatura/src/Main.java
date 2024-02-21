//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};

        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int tempMini = temperaturas[0][0];
        int tempMax = temperaturas[0][1];
        String ciudadesMax = ciudades[0];
        String ciudadesMin = ciudades[0];


for (int f = 1; f < ciudades.length; f++){
    int minActual =  temperaturas[f][0];
    if(minActual <tempMini){
        tempMini=minActual;
        ciudadesMin = ciudades[f];
    }
    int maxActual = temperaturas[f][1];
    if (maxActual >tempMax){
        tempMax = maxActual;
        ciudadesMax =ciudades[f];
    }
}

System.out.println("la ciudad de " + ciudadesMin + " registra una temperatura menor de " + tempMini +"cº");
System.out.println("la ciudad de " + ciudadesMax + " registra una temperatura mayor de " + tempMax +"cª") ;

        }
    }
