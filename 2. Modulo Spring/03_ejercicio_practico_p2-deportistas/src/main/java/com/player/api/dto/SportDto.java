package com.player.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.List;
import com.player.api.classes.Sport;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class SportDto {
    List<Sport> SportList;
}