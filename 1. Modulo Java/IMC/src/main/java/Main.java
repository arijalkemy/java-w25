public class Main {
    public static void main(String[] args){
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Fabian",22, "123");
        Persona persona3 = new Persona("Prueba", 23,"1234", 175, 80);
        int imc= persona3.getIMC();
        if(imc==-1){
            System.out.println("Bajo peso");
        }else if(imc==1){
            System.out.println("Sobre peso");
        }else{
            System.out.println("Saludable");
        }
        System.out.println(persona2.esMayorDeEdad());
    }
}
