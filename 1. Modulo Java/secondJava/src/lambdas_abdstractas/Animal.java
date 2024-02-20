package lambdas_abdstractas;

public abstract class Animal<T> {
    private int salud = 0;

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud += (this.salud < 10) ? salud : 0;
    }

    public abstract void makeSound();

    public void comerAnimal(T animal) {
        if (animal instanceof Perro) ((Perro) animal).comerCarne();
        else if (animal instanceof Gato) ((Gato) animal).comerCarne();
        else if (animal instanceof Vaca) ((Vaca) animal).comerHierba();
        else System.out.println("No se puede comer este animal");
    }
}
