import java.util.ArrayList;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private ArrayList<Inscripcion> participantesInscritos;

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.participantesInscritos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Inscripcion> getParticipantesInscritos() {
        return participantesInscritos;
    }

    public boolean inscribirParticipante(Inscripcion i){
        switch (this.getId()){
            case 3 ->{
                if (i.getParticipante().getEdad() < 18) {
                    System.out.printf("La inscripcion de %s no se pudo realizar \n", i.getParticipante().getNombre());
                    return false;
                }else{
                    i.setMontoAbonar(2800);
                    this.participantesInscritos.add(i);
                    return true;
                }

            }
            case 2 ->{
                if (i.getParticipante().getEdad() > 18){
                    i.setMontoAbonar(2300);
                }else{
                    i.setMontoAbonar(2000);
                }
                this.participantesInscritos.add(i);
                return true;
            }
            case 1 ->{
                if (i.getParticipante().getEdad() > 18){
                    i.setMontoAbonar(1500);
                }else{
                    i.setMontoAbonar(1300);
                }
                this.participantesInscritos.add(i);
                return true;
            }
            default -> {
                System.out.println("Categoria no valida");
                return false;
            }
        }
/*        if(this.getId() == 3) {
            if (i.getParticipante().getEdad() < 18) {
                System.out.println("La inscripcion no se puede realizar ya que es menor de edad");
            }
            i.setMontoAbonar(2800);
            this.participantesInscritos.add(i);
        }else if(this.getId() == 2){
            if (i.getParticipante().getEdad() < 18){
                i.setMontoAbonar(2300);
            }else{
                i.setMontoAbonar(2000);
            }
            this.participantesInscritos.add(i);
        }else if(this.getId() == 1){
            if (i.getParticipante().getEdad() < 18){
                i.setMontoAbonar(1500);
            }else{
                i.setMontoAbonar(1300);
            }
            this.participantesInscritos.add(i);
        }*/
    }

    public void desinscribirParticiapnte(Inscripcion i){
        if(!participantesInscritos.remove(i)){
            System.out.println("Participante no encontrado");
        }else{
            i.getParticipante().setNumInscripcion(-1);
            System.out.println("Participante " + i.getParticipante().getNombre() + " removido ");
        }

    }

    public int calcularRecaudo(){
        int sum = 0;
        for(Inscripcion i: this.participantesInscritos){
            sum += i.getMontoAbonar();
        }
        return sum;
    }
}
