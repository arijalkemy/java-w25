package bootcamp.relations.service.implementation;

import bootcamp.relations.dto.request.SaleRequestDTO;
import bootcamp.relations.model.Sale;
import bootcamp.relations.model.SaleDetail;
import bootcamp.relations.repository.ISaleDetailRepository;
import bootcamp.relations.repository.ISaleRepository;
import bootcamp.relations.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements ISaleService {
    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private ISaleDetailRepository saleDetailRepository;

    @Override
    public void createSale(SaleRequestDTO request) {
        Sale sale = new Sale();
        sale.setList(request.getSaleDetails().stream().map(d -> {
            SaleDetail sd = new SaleDetail();
            sd.setDescription(d.getDescription());
            sd.setSale(sale);
            return sd;
        }).toList());
        saleRepository.save(sale);
    }
}
