package meli.com.co.grupalelastic.repository;

import meli.com.co.grupalelastic.dto.ObraLiterariaDto;
import meli.com.co.grupalelastic.entity.ObraLiteraria;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    public List<ObraLiteraria> findAll();
    public List<ObraLiteraria> findAllByAutor(String autor);
    public List<ObraLiteraria> findAllByNombreContainingIgnoreCase(String nombre);
    public List<ObraLiteraria> findAllByAnioBefore(int anio);
    public List<ObraLiteraria> findAllByEditorial(String editorial);
}
