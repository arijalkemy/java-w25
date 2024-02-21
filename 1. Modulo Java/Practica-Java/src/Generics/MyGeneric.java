package Generics;

public class MyGeneric<T> {
    private T genericField;
    private Integer field;

    public MyGeneric(T genericField, Integer field) {
        this.genericField = genericField;
        this.field = field;
    }

    public T getGenericField() {
        return genericField;
    }
    public void setGenericField(T genericField) {
        this.genericField = genericField;
    }
}
