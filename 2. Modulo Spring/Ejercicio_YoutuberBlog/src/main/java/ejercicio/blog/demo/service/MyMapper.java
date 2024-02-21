package ejercicio.blog.demo.service;

import ejercicio.blog.demo.dto.EntradaDTO;
import ejercicio.blog.demo.model.EntradaBlog;
import ejercicio.blog.demo.repository.EntradaRepositorioImp;
import ejercicio.blog.demo.repository.IEntradaRepositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyMapper {
    public static EntradaBlog convertDtoToModel(EntradaDTO entradaDTO) {
        return new EntradaBlog(entradaDTO.getId(), entradaDTO.getTitulo(), entradaDTO.getNombreAutor(), entradaDTO.getFechaPub());
    }

    public static HashMap<Integer, EntradaDTO> convertirListaAHashMap(EntradaRepositorioImp repo) {
        List<EntradaBlog> listaModelo = repo.getBlogs();
        HashMap<Integer, EntradaDTO> listaBlogs = new HashMap<>();
        for(EntradaBlog e : listaModelo) {
            listaBlogs.put(e.getId(), new EntradaDTO(e.getId(), e.getTitulo(), e.getNombreAutor(), e.getFechaPub()));
        }
        return listaBlogs;
    }

    public static List<EntradaDTO> convertirListaModeloADto(List<EntradaBlog> listaEntradaModel) {
        List<EntradaDTO> listaEntradaDto = new ArrayList<>();

        for(EntradaBlog e : listaEntradaModel) {
            listaEntradaDto.add(new EntradaDTO(e.getId(), e.getTitulo(), e.getNombreAutor(), e.getFechaPub()));
        }

        return listaEntradaDto;
    }
}
