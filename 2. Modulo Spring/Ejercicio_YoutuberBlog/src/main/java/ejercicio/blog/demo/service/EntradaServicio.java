package ejercicio.blog.demo.service;

import ejercicio.blog.demo.dto.EntradaDTO;
import ejercicio.blog.demo.exceptions.EntradaNotFoundException;
import ejercicio.blog.demo.exceptions.IngresoEntradaExistenteException;
import ejercicio.blog.demo.model.EntradaBlog;
import ejercicio.blog.demo.repository.EntradaRepositorioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntradaServicio implements IEntradaServicio {

    @Autowired
    EntradaRepositorioImp repo;

    MyMapper miMapa = new MyMapper();
    private HashMap<Integer, EntradaDTO> listaBlogs = new HashMap<>();

    @Override
    public void guardarPubli(EntradaDTO entradaDto) {
        listaBlogs = miMapa.convertirListaAHashMap(repo);
        if (listaBlogs.get(entradaDto.getId()) != null) {
            throw new IngresoEntradaExistenteException("ID de publicacion existente.");
        }
        EntradaBlog entrada = miMapa.convertDtoToModel(entradaDto);
        repo.guardarPublicacion(entrada);
    }

    @Override
    public EntradaDTO getPubliById(Integer id) {
        listaBlogs = miMapa.convertirListaAHashMap(repo);
        for(Integer key : listaBlogs.keySet()) {
            if(key == id) {
                return listaBlogs.get(id);
            }
        }
        throw new EntradaNotFoundException("Entrada no encontrada.");
    }

    @Override
    public List<EntradaDTO> getBlogs() {
        List<EntradaDTO> listaEntrada = miMapa.convertirListaModeloADto(repo.getBlogs());
        return listaEntrada;
    }


}
