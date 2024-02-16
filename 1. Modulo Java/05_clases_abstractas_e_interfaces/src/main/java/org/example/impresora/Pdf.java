package org.example.impresora;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pdf extends Documento {
    String titulo;
    String autor;
    String genero;
    int paginas;

    @Override
    public String toString() {
        return "Pdf [titulo=\"" + titulo + "\", autor=" + autor + ", genero=" + genero + ", paginas="
                + paginas + "]";
    }
}
