public class Cliente {
    private String dni;
    private String name;

    public Cliente(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
