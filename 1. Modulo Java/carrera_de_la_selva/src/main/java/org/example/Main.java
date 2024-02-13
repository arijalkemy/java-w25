import java.util.ArrayList;

class Categoria{
    int  id;
    String nombre;
    String description;

    public Categoria( int id, String nombre, String description){

        this.id= id;
        this.nombre= nombre;
        this.description= description;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){

        this.nombre= nombre;
    }


    public String getDescription(){
        return this.description;
    }

    public void setDescription(String nombre){

        this.description= description;
    }

}
class Inscripcion{
    int numero_inscripcion;
    Categoria categoria;
    Participante participante;
    int monto;
    ArrayList<Inscripcion> Inscritos;
    public Inscripcion(int numero_inscripcion,Categoria categoria,Participante participante){
        this.numero_inscripcion= numero_inscripcion;
        this.categoria= categoria;
        this.participante=  participante;
        if (categoria.getNombre().equals("Circuito chico")){
            if(participante.getEdad()<18){
                this.monto = 1300;
            }
            else{this.monto = 1500;}

        }
        if (categoria.getNombre().equals("Circuito medio")){
            if(participante.getEdad()<18){
                this.monto = 2000;
            }
            else{this.monto = 2300;}

        }

        if (categoria.getNombre().equals("Circuito avanzado")){
            if(participante.getEdad()<18){
                System.out.println("Pequeñin, no te puedes inscribir al circuito avanzado");
            }
            else{this.monto = 2800;}

        }


    }

}

class Participante{
    int id;
    int dni;
    String nombre;
    String apellido;
    int edad;
    int celular;
    int numeroEmergencia;
    String grupoSanguineo;

    public Participante(int id, int dni, String nombre, String apellido, int edad, int celular, int numeroEmergencia, String grupoSanguineo){
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    // getters
    public int getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getCelular() {
        return celular;
    }

    public int getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setNumeroEmergencia(int numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

}
public class Main {

    public static void mostrarParticipante(Participante participante) {
        System.out.println("Nombre: " + participante.getNombre());
        System.out.println("Apellido: " + participante.getApellido());
        System.out.println("DNI: " + participante.getId());
        System.out.println("Edad: " + participante.getEdad());
        System.out.println("Celular: " + participante.getCelular());
        System.out.println("Número de Emergencias: " + participante.getNumeroEmergencia());
        System.out.println("Grupo Sanguíneo: " + participante.getGrupoSanguineo());
    }

    public static void main(String[] args) {

        Categoria chico = new Categoria(1,
                "Circuito chico",
                "2 km por selva y arroyos.");

        Categoria medio = new Categoria(2,"Circuito medio"," 5km por selva, arroyos y barro");
        Categoria grande = new Categoria(3,"Circuito grande","10 km por selva, arroyos, barro y escalada en piedra.");

        System.out.println("Circuitos creados:");
        System.out.println(chico.nombre + ": " + chico.description);
        System.out.println(medio.nombre + ": " + chico.description);
        System.out.println(grande.nombre + ": " + chico.description);


        Participante unParticipante = new Participante(1,1223,"JUAN", "PEREZ",23,110022,12123,"A+");

        Participante partChicoMenor = new Participante(
                1, 12345678, "Pepito", "Menguito", 17, 1199220011, 115555444, "A+"
        );

        Inscripcion unaInscripcion = new Inscripcion(1,chico,unParticipante);

        System.out.println("Participantes inscriptos");
        mostrarParticipante(unParticipante);
        System.out.println(" ");
        mostrarParticipante(partChicoMenor);

    }
}