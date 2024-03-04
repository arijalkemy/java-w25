// Se solicita la creación de una clase abstracta denominada Animal, de la cual deriven 3 animales:
// Perro, Gato y Vaca. Los 3 animales son capaces de “emitir sonidos”, para ello será necesario implementar
// un método que permita mostrar por pantalla el sonido que emite cada animal. Por ejemplo, en el caso del perro
// “guau”, el gato “miau” y la vaca “muuu”.

// A partir de esto, teniendo en cuenta los gustos alimenticios de cada animal (gato y perro son considerados
// carnívoros y la vaca un hervíboro), incluir las interfaces necesarias para contemplar los métodos comerCarne o
// comerHierba.
public abstract class Animal {
    public abstract void emitirSonido();
    public abstract void comerAnimal(Animal animal);
}
