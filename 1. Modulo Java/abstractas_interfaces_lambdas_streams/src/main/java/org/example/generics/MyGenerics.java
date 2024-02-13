package org.example.generics;

public class MyGenerics <T>{
    private T genericsField;
    private Integer field;

    public MyGenerics(T genericsField, Integer field) {
        this.genericsField = genericsField;
        this.field = field;
    }

    public T getGenericsField() {
        return genericsField;
    }

    public void setGenericsField(T genericsField) {
        this.genericsField = genericsField;
    }
}
