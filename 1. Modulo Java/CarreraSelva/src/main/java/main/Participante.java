package main;

public class Participante {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String nroEmergencia;
    private String grupoSanguineo;

    public Participante(int dni, String nombre, String apellido, int edad, String celular, String nroEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
/*
    - Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
    - Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
    - Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800

 */
    public void inscribirseACircuito(Circuito circuito){
       switch (circuito.getId()){
           case 1:{
               if(this.edad > 18){

               }
               else{

               }
               break;
           }
           case 2:{
               if(this.edad > 18){

               }
               else{

               }
               break;
           }
           default:{
               if(this.edad > 18){

               }
               else{

               }
               break;
           }
       }
    }
}
