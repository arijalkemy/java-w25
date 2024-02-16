public class Person {

    public int Id;
    public String Name;
    public int Age;

    public String Dni;

    public Double Weight;
    public Double Height;

    public Person() {

    }

    public Person(String name, int age, String dni) {
        Name = name;
        Age = age;
        Dni = dni;
    }

    public Person(int id, String name, int age, String dni, Double weight, Double height) {
        Id = id;
        Name = name;
        Age = age;
        Dni = dni;
        Weight = weight;
        Height = height;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public Double getWeight() {
        return Weight;
    }

    public void setWeight(Double weight) {
        Weight = weight;
    }

    public Double getHeight() {
        return Height;
    }

    public void setHeight(Double height) {
        Height = height;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int CalculateIMC(){
        double result = this.getWeight()/(this.getHeight() * this.getWeight());

        if( result < 20){
            return -1;
        } else if (result >= 20 && result <= 25) {
            return 0;
        }

        else{
            return 1;
        }
    }

    public boolean isUpperAge(){
        return this.Age > 18;
    }

    @Override
    public String toString() {
        return "nombre='" + this.getName() + '\'' +
                ", dni='" + this.getDni() + '\'' +
                ", edad=" + this.getAge() +
                ", peso=" + this.getWeight() +
                ", altura=" + this.getHeight();
    }


}
