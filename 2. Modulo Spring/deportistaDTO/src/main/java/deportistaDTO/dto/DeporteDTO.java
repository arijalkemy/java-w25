package deportistaDTO.dto;

public class DeporteDTO {
    private String nombre;
    private Integer nivel;

    public DeporteDTO(String nombre) {
        this.nombre = nombre;
    }


    // SETER AND GETER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
