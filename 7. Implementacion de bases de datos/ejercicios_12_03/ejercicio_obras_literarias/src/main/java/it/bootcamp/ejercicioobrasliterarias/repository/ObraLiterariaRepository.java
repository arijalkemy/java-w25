package it.bootcamp.ejercicioobrasliterarias.repository;

import it.bootcamp.ejercicioobrasliterarias.entity.ObraLiteraria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository <ObraLiteraria, String> {
    List<ObraLiteraria> findAll();
    List<ObraLiteraria> getObraLiterariasByAutor(String autor);
    List<ObraLiteraria> getObraLiterariasByNombreContaining(String contenido);
    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();
    List<ObraLiteraria> findAllByAnyoPrimeraPublicacionBefore(Integer year);
    List<ObraLiteraria> findAllByEditorialEqualsIgnoreCase(String editorial);
}
