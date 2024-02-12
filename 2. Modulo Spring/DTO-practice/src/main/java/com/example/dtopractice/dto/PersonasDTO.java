package com.example.dtopractice.dto;

import com.example.dtopractice.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonasDTO {
  private List<Persona> personas;
}
