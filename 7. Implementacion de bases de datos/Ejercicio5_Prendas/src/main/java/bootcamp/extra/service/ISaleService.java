package bootcamp.extra.service;

import bootcamp.extra.dto.ClothDTO;
import bootcamp.extra.dto.SaleDTO;
import bootcamp.extra.dto.request.SaleRequest;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    SaleDTO createSale(SaleRequest request);

    List<ClothDTO> getPrendasByVentasNumber(Long number);

    SaleDTO getSaleByNumber(Long number);

    List<SaleDTO> getSales();

    SaleDTO updateSale(Long number, SaleRequest request);

    void deleteSaleByNumber(Long number);

    List<SaleDTO> getVentasByDate(LocalDate date);
}
