package com.example.controllerW25.json;

import java.util.List;

public class Dad extends Person {
    private final List<String> children;
    private final int age;
    private final boolean hasWife;

    public Dad(String name, String lastName, List<String> children, int age, boolean hasWife) {
        super(name, lastName);
        this.children = children;
        this.age = age;
        this.hasWife = hasWife;
    }

    public List<String> getChildren() {
        return children;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasWife() {
        return hasWife;
    }
}
