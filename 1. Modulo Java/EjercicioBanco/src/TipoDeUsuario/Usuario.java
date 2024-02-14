package TipoDeUsuario;

import java.util.Random;

public abstract class Usuario {

    private String nombre;
    private Long idUsuario;
    private Double saldo;

    public Usuario(String nombre, Long idUsuario, Double saldo) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.saldo = saldo;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public abstract <T> void realizarTransaccion(T tipoDeTransaccion);

    public Integer generarNumeroAleatorio(){
        Random random = new Random();

        return random.nextInt(2) + 1;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", idUsuario=" + idUsuario +
                ", saldo=" + saldo +
                '}';
    }
}
