package obras_literarias.service;

import obras_literarias.dto.response.ObraLiterariaDto;
import obras_literarias.dto.request.NuevaObraDto;
import obras_literarias.dto.response.ResponseDto;
import obras_literarias.entity.ObraLiteraria;
import obras_literarias.exception.BadRequestException;
import obras_literarias.exception.NotFoundException;
import obras_literarias.repository.IObrasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObrasServiceImp implements IObrasService{
    IObrasRepository repository;
    ModelMapper mapper;

    public ObrasServiceImp(IObrasRepository repository){
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    @Override
    public ResponseDto saveObrasList(List<NuevaObraDto> obras) {
        List<ObraLiteraria> obrasToSave = obras.stream().map(o -> mapper.map(o, ObraLiteraria.class)).toList();
        obrasToSave.stream().map(o -> repository.save(o)).toList();
        return new ResponseDto("Obras guardadas con éxito");
    }

    @Override
    public List<ObraLiterariaDto> getAllByAutor(String autor){
        List<ObraLiteraria> obras = repository.findByAutor(autor);
        List<ObraLiterariaDto> obrasByAutor = obras.stream()
                .map(o-> mapper.map(o, ObraLiterariaDto.class))
                .toList();
        if (obrasByAutor.isEmpty()) {
            throw new NotFoundException("No se encontraron obras del autor " + autor);
        }
        return obrasByAutor;
    }

    @Override
    public List<ObraLiterariaDto> getAllByTitulo(String titulo){
        List<ObraLiteraria> obras = repository.findByNombreContaining(titulo);
        List<ObraLiterariaDto> obrasByTitulo = obras.stream()
                .map(o-> mapper.map(o, ObraLiterariaDto.class))
                .toList();
        if (obrasByTitulo.isEmpty()) {
            throw new NotFoundException("No se encontraron obras que contengan '" + titulo +"' en el título");
        }
        return obrasByTitulo;
    }

    @Override
    public List<ObraLiterariaDto> findTop5ByPaginas(){
        List<ObraLiteraria> obras = repository.findTop5ByOrderByPaginasDesc();
        List<ObraLiterariaDto> top5ObrasByPaginas = obras.stream()
                .map(o-> mapper.map(o, ObraLiterariaDto.class))
                .toList();
        if (top5ObrasByPaginas.isEmpty()) {
            throw new NotFoundException("No se encontraron obras");
        }
        return top5ObrasByPaginas;
    }

    @Override
    public List<ObraLiterariaDto> findByAnnoPublicacionBefore(String anno){
        if (!anno.matches("^[0-9]{4}$")) {
            throw new BadRequestException("El año de publicación debe tener 4 dígitos");
        }
        Integer annoInt = Integer.parseInt(anno);
        List<ObraLiteraria> obras = repository.findByAnnoPublicacionBefore(annoInt);
        List<ObraLiterariaDto> obrasByAnnoPublicationBefore = obras.stream()
                .map(o-> mapper.map(o, ObraLiterariaDto.class))
                .toList();
        if (obrasByAnnoPublicationBefore.isEmpty()) {
            throw new NotFoundException("No se encontraron obras publicadas antes de " + anno);
        }
        return obrasByAnnoPublicationBefore;
    }

    @Override
    public List<ObraLiterariaDto> findByEditorial(String editorial){
        List<ObraLiteraria> obras = repository.findByEditorial(editorial);
        List<ObraLiterariaDto> obrasByEditorial = obras.stream()
                .map(o-> mapper.map(o, ObraLiterariaDto.class))
                .toList();
        if (obrasByEditorial.isEmpty()) {
            throw new NotFoundException("No se encontraron obras de la editorial " + editorial);
        }
        return obrasByEditorial;
    }
}