package com.bootcamp.sportist.dto.response;

import com.bootcamp.sportist.model.Sport;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class SingleSportDTO {
    Sport sport;

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
