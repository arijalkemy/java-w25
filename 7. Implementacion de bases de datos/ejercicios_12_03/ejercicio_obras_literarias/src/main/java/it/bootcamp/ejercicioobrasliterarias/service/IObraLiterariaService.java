package it.bootcamp.ejercicioobrasliterarias.service;

import it.bootcamp.ejercicioobrasliterarias.dto.ObraLiterariaDto;

import java.util.List;

public interface IObraLiterariaService {

        public List<ObraLiterariaDto> getAllObras();
        public List<ObraLiterariaDto> getObrasByAutor(String autor);
        public List<ObraLiterariaDto> getObrasLikeNombre(String nombre);
        public List<ObraLiterariaDto> getObrasTop5Paginas();
        public List<ObraLiterariaDto> getObrasReleasedBeforeAnio(Integer anio);
        public List<ObraLiterariaDto> getObrasByEditorial(String editorial);

        public ObraLiterariaDto saveObra(ObraLiterariaDto obraLiterariaDto);
}
