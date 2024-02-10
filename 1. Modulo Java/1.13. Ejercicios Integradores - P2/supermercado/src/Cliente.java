import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static List<Cliente> clientes = new ArrayList<>();
    private int dni;
    private String nombre;
    private String apellido;

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        clientes.add(this);
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static void addCliente(Cliente cliente) {
        Cliente.clientes.add(cliente);
    }

    public static void removeCliente(int dniCliente) {
        Cliente.clientes.removeIf(cliente -> cliente.getDni() == dniCliente);
    }

    public static Cliente getCliente(int dniCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dniCliente) {
                System.out.println(cliente);
                return cliente;
            }
        }
        System.out.println("No se encontró el cliente");
        return null;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
