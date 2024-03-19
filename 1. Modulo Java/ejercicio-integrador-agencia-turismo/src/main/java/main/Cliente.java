package main;

public class Cliente {

    private Long id;
    private String name;
    private int dni;

    public Cliente(Long id, String name, int dni) {
        this.id = id;
        this.name = name;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dni=" + dni +
                '}';
    }
}
