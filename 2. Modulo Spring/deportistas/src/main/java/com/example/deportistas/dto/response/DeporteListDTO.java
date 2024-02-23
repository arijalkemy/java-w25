package com.example.deportistas.dto.response;


import com.example.deportistas.models.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeporteListDTO {


   private  List<Deporte> deportes;


}
