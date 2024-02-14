package org.example.ropa.dominio;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class GuardarRopa {

    int contador = -1;
    Map<Integer, List<Prenda>> prendas = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        contador++;
        prendas.put(contador, listaDePrendas);
        return contador;
    }

    public void mostrarPrendas() {
        for (Integer id : prendas.keySet()) {
            List<Prenda> listaDePrendas = prendas.get(id);
            System.out.println("Identificador: " + id + ", Prendas: " + listaDePrendas);
        }
    }

    public List<Prenda> devolverPendas(Integer numero) {
        return prendas.get(numero);
    }

}
