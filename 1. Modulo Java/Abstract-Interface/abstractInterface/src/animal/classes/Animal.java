package animal.classes;

public abstract class Animal {
    private String name;
    private String color;
    protected String type;
    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void eatAnimal(Animal animal){
        System.out.println("Me he comido un animal de tipo "+ animal.getType());
    }

    public abstract void makeSound();
}
