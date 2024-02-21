package ejercicio.blog.demo.service;

import ejercicio.blog.demo.dto.EntradaDTO;
import ejercicio.blog.demo.model.EntradaBlog;

import java.util.HashMap;
import java.util.List;

public interface IMyMapper {
    public EntradaBlog convertDtoToModel(EntradaDTO entradaDTO);
    public HashMap<Integer, EntradaDTO> convertirListaAHashMap();
    public List<EntradaDTO> convertirListaModeloADto(List<EntradaBlog> listaEntradaModel);
}
