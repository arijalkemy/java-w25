package bootcamp.miniseries.util.mapper;

import bootcamp.miniseries.dto.request.MiniSerieRequestDTO;
import bootcamp.miniseries.dto.response.MiniSerieResponseDTO;
import bootcamp.miniseries.model.MiniSerie;

public class MiniserieMapper {

    public static MiniSerieResponseDTO getResponse(MiniSerie miniserie) {
        return MiniSerieResponseDTO.builder()
                .id(miniserie.getId())
                .name(miniserie.getName())
                .rating(miniserie.getRating())
                .amountOfAwards(miniserie.getAmountOfAwards())
                .build();
    }

    public static MiniSerie getEntity(MiniSerieRequestDTO dto) {
        return MiniSerie.builder()
                .name(dto.getName())
                .rating(dto.getRating())
                .amountOfAwards(dto.getAmountOfAwards())
                .build();
    }

}
