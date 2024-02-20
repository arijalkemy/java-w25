package org.example.ejercicio1;

import java.util.List;

public class Cobrador extends Cliente{
    public Cobrador(){
        super(List.of(new RetiroDeEfectivo(), new ConsultaDeSaldo()));
    }
}
