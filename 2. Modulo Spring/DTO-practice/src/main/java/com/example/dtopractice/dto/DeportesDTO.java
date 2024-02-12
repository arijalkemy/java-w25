package com.example.dtopractice.dto;

import com.example.dtopractice.model.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeportesDTO {
  private List<Deporte> deportes;
}
