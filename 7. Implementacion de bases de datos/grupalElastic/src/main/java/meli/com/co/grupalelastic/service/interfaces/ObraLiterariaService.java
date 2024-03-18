package meli.com.co.grupalelastic.service.interfaces;

import meli.com.co.grupalelastic.dto.ObraLiterariaDto;
import meli.com.co.grupalelastic.entity.ObraLiteraria;
import meli.com.co.grupalelastic.repository.IObraLiterariaRepository;
import meli.com.co.grupalelastic.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static meli.com.co.grupalelastic.util.Mapper.obraLiterariaDtoToObraLiteraria;
import static meli.com.co.grupalelastic.util.Mapper.obraLiterariaToObraLiterariaDto;

@Service
public class ObraLiterariaService implements IObraLiterariaService{

    private final IObraLiterariaRepository repository;

    public ObraLiterariaService(IObraLiterariaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ObraLiterariaDto saveObra(ObraLiterariaDto obraLiterariaDto) {
        ObraLiteraria obraLiteraria = obraLiterariaDtoToObraLiteraria(obraLiterariaDto);
        return obraLiterariaToObraLiterariaDto(repository.save(obraLiteraria));
    }

    @Override
    public List<ObraLiterariaDto> getAll() {
        return repository.findAll()
                .stream()
                .map(Mapper::obraLiterariaToObraLiterariaDto)
                .toList();
    }

    @Override
    public ObraLiterariaDto getById(String id) {
        return obraLiterariaToObraLiterariaDto(repository.findById(id).orElseThrow());
    }

    @Override
    public List<ObraLiterariaDto> getAllByAutor(String autor) {
        return repository.findAllByAutor(autor)
                .stream()
                .map(Mapper::obraLiterariaToObraLiterariaDto)
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> getAllByTitleLike(String nombre) {
        return repository.findAllByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(Mapper::obraLiterariaToObraLiterariaDto)
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> getAllBeforeAnio(int anio) {
        return repository.findAllByAnioBefore(anio)
                .stream()
                .map(Mapper::obraLiterariaToObraLiterariaDto)
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> getALlByEditorial(String editorial) {
        return repository.findAllByEditorial(editorial)
                .stream()
                .map(Mapper::obraLiterariaToObraLiterariaDto)
                .toList();
    }

}
