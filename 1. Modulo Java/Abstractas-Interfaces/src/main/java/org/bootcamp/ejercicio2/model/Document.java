package org.bootcamp.ejercicio2.model;

public abstract class Document {
    protected String typeDocument;

    public Document(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }
}
