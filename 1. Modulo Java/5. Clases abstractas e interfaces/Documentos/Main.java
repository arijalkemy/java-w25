public class Main {
    public static void main(String[] args) {
        Libro cuento = new Libro(50, "Pepito","Aventuras de pepito", "Accion");
        cuento.Imprimir();
        Curriculums curri = new Curriculums("Pepe", "Pepito",15, "Carpintero", new String[]{"Java", "C++", "Comunicación"});
        curri.Imprimir();
        Informe inf = new Informe(50, 15,"pepito", "pepita");
        inf.Imprimir();
    }
}
