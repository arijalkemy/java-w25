package com.mercadolibre.calculadorametroscuadrados.dto;

public class HouseResponseDTO extends HouseDTO {
    private Integer squareFeet;
    private Integer price;
    private RoomDTO biggest;

    public HouseResponseDTO() {
    }

    public HouseResponseDTO(HouseDTO house) {
    }

    public HouseResponseDTO(Integer squareFeet, Integer price, RoomDTO biggest) {
        this.squareFeet = squareFeet;
        this.price = price;
        this.biggest = biggest;
    }


    public Integer getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(Integer squareFeet) {
        this.squareFeet = squareFeet;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public RoomDTO getBiggest() {
        return biggest;
    }

    public void setBiggest(RoomDTO biggest) {
        this.biggest = biggest;
    }
}
