package org.example.ejercicio1;

import java.util.List;

public class Basic extends Cliente{
    public Basic(){
        super(List.of(new ConsultaDeSaldo(), new PagoDeServicios(), new RetiroDeEfectivo() ));
    }
}
