package bootcamp.extra.service.implementation;

import bootcamp.extra.dto.ClothDTO;
import bootcamp.extra.dto.SaleDTO;
import bootcamp.extra.dto.request.SaleRequest;
import bootcamp.extra.exception.SaleNotFoundException;
import bootcamp.extra.model.Sale;
import bootcamp.extra.repository.IClothRepository;
import bootcamp.extra.repository.ISaleRepository;
import bootcamp.extra.service.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleServiceImp implements ISaleService {

    private final ISaleRepository ventaRepository;

    private final IClothRepository prendaRepository;

    private final ModelMapper mapper = new ModelMapper();

    public SaleServiceImp(ISaleRepository ventaRepository, IClothRepository prendaRepository){
        this.ventaRepository = ventaRepository;
        this.prendaRepository = prendaRepository;
    }

    @Override
    public SaleDTO createSale(SaleRequest request) {
        Sale savedSale = ventaRepository.save(mapper.map(request, Sale.class));
        return mapper.map(savedSale, SaleDTO.class);
    }

    @Override
    public List<ClothDTO> getPrendasByVentasNumber(Long number) {
        return prendaRepository.getClothesOfSaleWithNumber(number).stream().map(v -> mapper.map(v, ClothDTO.class)).toList();
    }

    @Override
    public SaleDTO getSaleByNumber(Long number) {
        Sale sale = ventaRepository.findById(number).orElseThrow(() -> new SaleNotFoundException(number));
        return mapper.map(sale, SaleDTO.class);
    }

    @Override
    public List<SaleDTO> getSales(){
        return ventaRepository.findAll().stream().map(sale -> mapper.map(sale, SaleDTO.class)).toList();
    }

    @Override
    public SaleDTO updateSale(Long number, SaleRequest request) {
        Sale sale = mapper.map(request, Sale.class);
        sale.setId(number);
        Sale savedSale = ventaRepository.save(sale);
        return mapper.map(savedSale, SaleDTO.class);
    }

    @Override
    public void deleteSaleByNumber(Long number){
        ventaRepository.deleteById(number);
    }

    @Override
    public List<SaleDTO> getVentasByDate(LocalDate date) {
        return ventaRepository.findByDate(date).stream().map(v -> mapper.map(v, SaleDTO.class)).toList();
    }

}
