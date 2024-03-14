package it.bootcamp.ejercicioobrasliterarias.service;

import it.bootcamp.ejercicioobrasliterarias.dto.ObraLiterariaReqDTO;
import it.bootcamp.ejercicioobrasliterarias.dto.ObraLiterariaResDTO;

import java.util.List;

public interface IObraLiterariaService {

        public ObraLiterariaResDTO saveObra(ObraLiterariaReqDTO obraLiterariaDto);

        public List<ObraLiterariaResDTO> getAllObras();

        public List<ObraLiterariaResDTO> getObrasByAutor(String autor);

        public List<ObraLiterariaResDTO> getObrasLikeNombre(String nombre);

        public List<ObraLiterariaResDTO> getObrasTop5Paginas();

        public List<ObraLiterariaResDTO> getObrasReleasedBeforeAnio(Integer anio);

        public List<ObraLiterariaResDTO> getObrasByEditorial(String editorial);
}
