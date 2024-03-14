package bootcamp.extra.service;

import bootcamp.extra.dto.ClothDTO;
import bootcamp.extra.dto.RequestClothDTO;
import bootcamp.extra.dto.ResponseDTO;

import java.util.List;
public interface IClothService {

    ClothDTO createPrenda(RequestClothDTO cloth);

    List<ClothDTO> getPrendas(String name);

    ClothDTO getPrendaByCode(String code);

    ClothDTO updatePrenda(String code, RequestClothDTO body);

    ResponseDTO deletePrenda(String code);

    List<ClothDTO> getPrendasBySize(String size);
}
