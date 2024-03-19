package org.example;

public class Category {

    public Category (String description, String nameCircuit, String idCircuit){
        this.description = description;
        this.nameCircuit = nameCircuit;
        this.idCircuit = idCircuit;
    }

    public Category (){}

    private String description;
    private String nameCircuit;
    private String idCircuit;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameCircuit() {
        return nameCircuit;
    }

    public void setNameCircuit(String nameCircuit) {
        this.nameCircuit = nameCircuit;
    }

    public String getIdCircuit() {
        return idCircuit;
    }

    public void setIdCircuit(String idCircuit) {
        this.idCircuit = idCircuit;
    }

    @Override
    public String toString() {
        return "Category{" +
                "description='" + description + '\'' +
                ", nameCircuit='" + nameCircuit + '\'' +
                ", idCircuit='" + idCircuit + '\'' +
                '}';
    }
}
