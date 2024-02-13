package com.bootcamp.sportist.dto.response;

import com.bootcamp.sportist.model.Sport;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class SportsPersonDTO {
    private String personName;
    private String lastName;
    private List<String> sportsName;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getSportsName() {
        return sportsName;
    }

    public void setSportsName(List<String> sportsName) {
        this.sportsName = sportsName;
    }
}
