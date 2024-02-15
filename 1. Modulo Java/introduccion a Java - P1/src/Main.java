/*
Temperaturas Globales

Un portal de noticias tiene registrados datos de las diferentes temperaturas que obtuvieron
algunas ciudades del mundo durante el año pasado; a partir de estos registros, pudieron
determinar la más baja y la más alta para cada una de las ciudades. Por ejemplo, se determinó
que para Londres, la mínima fue de -2º C y la máxima de 33º C. Sin embargo, actualmente necesitan
armar una noticia en donde especifiquen cuál es la temperatura máxima que hubo entre todas las
ciudades registradas y cuál fue la mínima. Para ello cuentan con un vector con los nombres de
cada una de las ciudades y una matriz de dos columnas que especifican su temperatura máxima y
mínima, los cuales se especifican a continuación:

Vector Ciudades: ['Londres', 'Madrid', 'Nueva York', 'Buenos Aires', 'Asunción', 'São Paulo', 'Lima', 'Santiago de Chile', 'Lisboa', 'Tokio']
Matriz Temperaturas: [[-2, 33], [-3, 32], [-8, 27], [4, 37], [6, 42], [5, 43], [0, 39], [-7, 26], [-1, 31], [-10, 35]]

Sabiendo que cada índice de fila representa a una ciudad. Se necesita conocer la mayor y la menor
temperatura entre todas las ciudades; al mismo tiempo se deberá especificar el nombre de la ciudad.
Por ejemplo, la menor temperatura la tuvo Tokio, con -10 º C.
*
* */

public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int[] minTemperature = {0, temperatures[0][0]};
        int[] maxTemperature = {0, temperatures[0][1]};

        for(int i = 0; i<cities.length; i++) {
            if (temperatures[i][0] < minTemperature[1]) {
                minTemperature[0] = i;
                minTemperature[1] = temperatures[i][0];
            }

            if (temperatures[i][1] > maxTemperature[1]) {
                maxTemperature[0] = i;
                maxTemperature[1] = temperatures[i][1];
            }
        }

        System.out.println("la menor temperatura es: " + minTemperature[1] + " Y pertenece a la ciudad: " + cities[minTemperature[0]]);
        System.out.println("la mayor temperatura es: " + maxTemperature[1] + " Y pertenece a la ciudad: " + cities[maxTemperature[0]]);
    }
}

/*
La salida por consola es la siguiente:

la menor temperatura es: -10 Y pertenece a la ciudad: Tokio
la mayor temperatura es: 43 Y pertenece a la ciudad: São Paulo
*/