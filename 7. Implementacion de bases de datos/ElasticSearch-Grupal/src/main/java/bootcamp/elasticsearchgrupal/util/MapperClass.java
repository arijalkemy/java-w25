package bootcamp.elasticsearchgrupal.util;

import bootcamp.elasticsearchgrupal.dto.request.ObraLiterariaRequestDTO;
import bootcamp.elasticsearchgrupal.dto.response.ObraLiterariaResponseDTO;
import bootcamp.elasticsearchgrupal.model.ObraLiteraria;

public class MapperClass {


    public static ObraLiteraria dtoToEntity(ObraLiterariaRequestDTO dto) {
        return ObraLiteraria.builder()
                .nombre(dto.getNombre())
                .autor(dto.getAutor())
                .cantidadDePaginas(dto.getCantidadDePaginas())
                .editorial(dto.getEditorial())
                .anioDePrimeraPublicacion(dto.getAnioDePrimeraPublicacion())
                .build();
    }

    public static ObraLiterariaResponseDTO entityToDto(ObraLiteraria ol) {
        return ObraLiterariaResponseDTO.builder()
                .id(ol.getId())
                .nombre(ol.getNombre())
                .autor(ol.getAutor())
                .cantidadDePaginas(ol.getCantidadDePaginas())
                .editorial(ol.getEditorial())
                .anioDePrimeraPublicacion(ol.getAnioDePrimeraPublicacion())
                .build();
    }

}
