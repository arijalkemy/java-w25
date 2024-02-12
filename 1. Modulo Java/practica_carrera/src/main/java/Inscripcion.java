public class Inscripcion {
    int numeroInscripcion;
    Categoria categoria;
    Participante participante;
    int monto;

    public int getMonto() {
        return monto;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
    }

    public void calcularMonto(){
        switch (this.categoria.id){
            case 1: {
                if (this.participante.edad > 18) {
                    this.monto = 1500;
                } else {
                    this.monto = 1300;
                }
                break;
            }
            case 2:{
                if (this.participante.edad > 18) {
                    this.monto = 2300;
                } else {
                    this.monto = 2000;
                }
                break;
            }

            case 3:{
                if (this.participante.edad > 18) {
                    this.monto = 2800;
                } else {
                    this.monto = -1;
                }
                break;
            }
        }


    }





}
