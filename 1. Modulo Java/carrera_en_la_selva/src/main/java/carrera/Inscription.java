package carrera;

public class Inscription {
    int id;
    Category category;
    Competidor participante;
    double monto;

    public int calcularPrecio(Competidor competidor, Category category){
        int price=0;
        if(category.getNombre().equals("chico")){
            if(competidor.getEdad()>18){
                price= 1300;
            }else{
                price= 1500;
            }
        }
        if(category.getNombre().equals("medio")){
            if(competidor.getEdad()>18){
                price= 2000;
            }else{
                price= 2300;
            }
        }
        if(category.getNombre().equals("avanzado")){
            if(competidor.getEdad()>18){
                price= 2800;
            }else{
                throw new IllegalArgumentException("No se puede inscribir un menor de edad al circuito avanzado");
            }
        }
        return price;
    }

    public Inscription() {
    }

    public Inscription(int id, Category category, Competidor participante) {
        this.id = id;
        this.category = category;
        this.participante = participante;
        this.monto = calcularPrecio(participante, category);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Competidor getParticipante() {
        return participante;
    }

    public void setParticipante(Competidor participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @java.lang.Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", category=" + category +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }
}
