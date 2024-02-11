//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] paises = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asjuncion", "Sao Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokyo"};
        int[][] temperaturas = {{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10},{33,32,27,37,42,43,39,26,31,35}};
        int minimo = 0;
        int maximo = 0;

        for (int i = 1; i< paises.length; i++){
                if(temperaturas[0][i] < temperaturas[0][minimo]){
                    minimo = i;
                }
                if (temperaturas [1][i] > temperaturas[1][maximo]){
                    maximo = i;
                }
            }


        System.out.println("La temperatura minima fue " + temperaturas[0][minimo] + " del pais " + paises[minimo]);
        System.out.println("La temperatura maxima fue " + temperaturas[1][maximo] + " del pais " + paises[maximo]);
    }
}