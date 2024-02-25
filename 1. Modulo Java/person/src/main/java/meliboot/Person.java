package meliboot;

public class Person {
    public String name;
    public int age;
    public long dni;
    public int weight;
    public int height;

    public Person(){}

    public Person(String name,int age,long dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public  Person(String name,int age,long dni,int weight, int height){
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public double toCalculeIMC(){
        var result =this.weight/(Math.pow(this.height,2));
        return result < 20 ? -1 : result <= 25 ? 0: 1;
    }

    public boolean isOfLegalAge(){
        return this.age >= 18;
    }

    @Override
    public String toString(){
        return String.format("Name: %s \nAge: %d \nDni: %d \nWeight: %d \nHeight: %d",
                this.name,this.age,this.dni,this.weight,this.height);
    }
}

