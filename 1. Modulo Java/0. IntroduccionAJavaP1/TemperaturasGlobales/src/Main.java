//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String [] ciudades = new String[]{"Londres", "Madrid", "NuevaYork", "BuenosAires", "Asunción", "SãoPaulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int [] temperaturas_bajas = new int[]{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10};
        int [] temperaturas_altas = new int[]{33, 32, 27, 37, 42, 43, 39, 26, 31, 35};
        int temperatura_baja = temperaturas_bajas[0];
        int temperatura_alta = temperaturas_altas[0];
        int indice_alto = 0;
        int indice_bajo = 0;


        for(int i = 0; i < ciudades.length; i++){
            if(temperaturas_altas[i] > temperatura_alta){
                temperatura_alta = temperaturas_altas[i];
                indice_alto = i;
            }
            if(temperaturas_bajas[i] < temperatura_baja) {
                temperatura_baja = temperaturas_bajas[i];
                indice_bajo = i;
            }
        }

        System.out.println("La temperatura más alta es en la ciudad " + ciudades[indice_alto] + ":" + temperaturas_altas[indice_alto]);
        System.out.println("La temperatura más baja es en la ciudad " + ciudades[indice_bajo] + ":" + temperaturas_bajas[indice_bajo]);
        
    }
}