public class Client {
    private static Long idGenerator = 0L;
    private Long id;
    private Long dni;
    private String name;
    private String lastname;
    
    public Client() {
    }

    public Client(Long dni, String name, String lastname) {
        idGenerator += 1L;
        this.id = idGenerator;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", dni=" + dni + ", name=" + name + ", lastname=" + lastname + "]";
    }
}
