package com.main;

public class Main {

    public static void main(String[] args) {
        SerieProgresiva1 serieProgresiva1 = new SerieProgresiva1();
        SerieProgresiva2 serieProgresiva2 = new SerieProgresiva2();
        SerieProgresiva1 serieProgresiva3 = new SerieProgresiva1();

        serieProgresiva1.establecerValorInicial(2);
        serieProgresiva2.establecerValorInicial(1f);
        serieProgresiva3.establecerValorInicial(3);

        System.out.println("Primera serie");
        imprimirSerie1(serieProgresiva1);

        System.out.println("Segunda serie");
        imprimirSerie2(serieProgresiva2);

        System.out.println("Tercera serie");
        imprimirSerie1(serieProgresiva3);

        System.out.println("Reiniciar serie1");
        serieProgresiva1.reiniciarSerie();
        System.out.println(serieProgresiva1.siguienteNumero());

        System.out.println("Reiniciar serie2");
        serieProgresiva2.reiniciarSerie();
        System.out.println(serieProgresiva2.siguienteNumero());

    }

    public static void imprimirSerie1(SerieProgresiva1 serieProgresiva1){
        for (int i = 0; i < 4; i++) {
            System.out.println(serieProgresiva1.siguienteNumero());
        }
    }
    public static void imprimirSerie2(SerieProgresiva2 serieProgresiva2){
        for (int i = 0; i < 4; i++) {
            System.out.println(serieProgresiva2.siguienteNumero());
        }
    }
}
