package org.bootcamp.model;

public class Client {
    private int idClient;
    private String nameClient;

    public Client(int idClient, String nameClient) {
        this.idClient = idClient;
        this.nameClient = nameClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nameClient='" + nameClient + '\'' +
                '}';
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNameClient() {
        return nameClient;
    }
}
