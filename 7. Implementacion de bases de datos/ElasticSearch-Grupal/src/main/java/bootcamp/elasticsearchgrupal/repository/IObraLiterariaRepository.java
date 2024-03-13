package bootcamp.elasticsearchgrupal.repository;

import bootcamp.elasticsearchgrupal.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    List<ObraLiteraria> findAll();
    List<ObraLiteraria> findObraLiterariaByNombreContains(String word);

    List<ObraLiteraria> findObraLiterariaByAutorEqualsIgnoreCase(String autor);

    List<ObraLiteraria> findObraLiterariasByAnioDePrimeraPublicacionIsBefore(Integer year);

    List<ObraLiteraria> findObraLiterariaByEditorialEqualsIgnoreCase(String editorial);

}
