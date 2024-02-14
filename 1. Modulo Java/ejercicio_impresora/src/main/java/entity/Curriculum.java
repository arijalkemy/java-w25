package entity;

import service.IPrintable;

public class Curriculum implements IPrintable {
    private Person person;

    public Curriculum(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "person=" + person +
                '}';
    }
}
