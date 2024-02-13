package com.springlh.ejercicios0902.model.practicas;

public class ServicioHabitacion {
    ServicioClasico sc;
    ServicioPremium sp;

    //inyección por constructor
    public ServicioHabitacion(ServicioClasico sc, ServicioPremium sp) {
        this.sc = sc;
        this.sp = sp;
    }
}
