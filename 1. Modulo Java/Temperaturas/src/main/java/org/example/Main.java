public static void main(String[] args) {

    String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
    int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}}

    int menTemp = 0;
    int mayTemp = 0;
    int posMin = 0;
    int posMax = 0;

    for ( int i = 0 ; i < ciudades.length; i++){
        for ( int j = 0; j < 2; j++){
            if (menTemp > temperaturas[i][j]) {
                menTemp = temperaturas[i][j];
                posMin = i;
                //System.out.println(menTemp);
            }
            if (temperaturas[i][j] > mayTemp){
                mayTemp = temperaturas[i][j];
                posMax = i;
                //System.out.println(mayTemp);
            }
        }
    }

    System.out.println("La ciudad que tuve menor temperatura fue: " + ciudades[posMin] + " con " + menTemp);
    System.out.println("Y la ciudad que tuvo mayor temperatura fue: " + ciudades[posMax] + " con " + mayTemp);

}
