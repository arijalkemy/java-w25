public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc=peso/(Math.pow(altura, 2));

        if(imc<20){
            System.out.println("Bajo peso");
            return -1;
        }else if(imc<=25){
            System.out.println("Peso saludable");
            return 0;
        }else{
            System.out.println("Sobrepeso");
            return 1;
        }
    }

    public boolean esMayor(){
        return this.edad>18;
    }

    @Override
    public String toString() {
        String mensaje="Nombre:"+nombre+"\nEdad:"+edad+"\nDNI:"+dni+"\nPeso:"+peso+"\nAltura:"+altura;
        return mensaje;
    }
}
