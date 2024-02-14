package entity;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<String> skills = new ArrayList<>();
    private List<String> experience = new ArrayList<>();

    public Person(List<String> skills, List<String> experience) {
        this.skills = skills;
        this.experience = experience;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Person{" +
                "skills=" + skills +
                ", experience=" + experience +
                '}';
    }

}
