package obras_literarias.repository;

import obras_literarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObrasRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    //Retornar las obras de un determinado autor.
    List<ObraLiteraria> findByAutor(String autor);
    //Retornar las obras que contengan palabras claves en sus títulos.
    List<ObraLiteraria> findByNombreContaining(String nombre);
    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    List<ObraLiteraria> findTop5ByOrderByPaginasDesc();
    //Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    List<ObraLiteraria> findByAnnoPublicacionBefore(Integer annoPublicacion);
    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    List<ObraLiteraria> findByEditorial(String editorial);
}