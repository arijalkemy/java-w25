package com.ConcesionarioAutos.demo.dto;

import java.util.Date;

public class servicesDTO {

    private Date date;
    private Integer kilometers;
    private String description;

public servicesDTO(Date date, Integer kilometers, String description) {
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }

    public servicesDTO() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
