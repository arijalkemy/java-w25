package com.bootcamp.sportist.dto.response;

import com.bootcamp.sportist.model.Sport;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class AllSportsDTO {
    private List<Sport> sportsList;

    public List<Sport> getSportsList() {
        return sportsList;
    }

    public void setSportsList(List<Sport> sportsList) {
        this.sportsList = sportsList;
    }
}
