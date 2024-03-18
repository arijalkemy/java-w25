package meli.com.co.grupalelastic.service.interfaces;

import meli.com.co.grupalelastic.dto.ObraLiterariaDto;

import java.util.List;

public interface IObraLiterariaService {

    public ObraLiterariaDto saveObra(ObraLiterariaDto obraLiterariaDto);
    public List<ObraLiterariaDto> getAll();
    public ObraLiterariaDto getById(String id);
    public List<ObraLiterariaDto> getAllByAutor(String autor);
    public List<ObraLiterariaDto> getAllByTitleLike(String title);
    public List<ObraLiterariaDto> getAllBeforeAnio(int anio);
    public List<ObraLiterariaDto> getALlByEditorial(String editorial);

}
