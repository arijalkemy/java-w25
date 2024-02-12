package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Gato michi = new Gato();
        Perro firulais = new Perro();
        Vaca lola = new Vaca();

        michi.ComeCarne();
        michi.emitirSonido();

        firulais.ComeCarne();
        firulais.emitirSonido();
        firulais.ComeAnimal(michi);//el perro se come un gato

        lola.ComeHierba();
        lola.emitirSonido();
    }
}