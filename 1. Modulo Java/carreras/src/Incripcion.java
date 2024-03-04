public class Incripcion {
    int id;
    String categoria;
    Participante participante;
    int monto;

    public Incripcion(int id, String categoria, Participante participante, int monto) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
    }

    public void incribirse(Participante participante) {
        if(categoria.equals("chico") && participante.getEdad() < 18) {
            monto = 1300;
        } else {
            monto = 1500;
        }

        if(categoria.equals("medio") && participante.getEdad() < 18) {
            monto = 2000;
        } else {
            monto = 2300;
        }

        if(categoria.equals("avanzado") && participante.getEdad() < 18) {
            System.out.println("No se permite inscripciones a MENORES DE 18 AÑOS");
        } else {
            monto = 2800;
        }

        System.out.println("DEBE PAGAR "+monto);
    }

}
