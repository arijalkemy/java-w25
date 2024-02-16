package org.example.impresora;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Informe extends Documento {
    String texto;
    String autor;
    String revisor;
    int paginas;
    @Override
    public String toString() {
        return "Informe [texto=\"" + texto + "\", autor=" + autor + ", revisor=" + revisor
                + ", paginas=" + paginas + "]";
    }
}
