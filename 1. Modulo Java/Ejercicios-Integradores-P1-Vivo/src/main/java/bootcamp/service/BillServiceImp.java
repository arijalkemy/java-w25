package bootcamp.service;

import bootcamp.domain.Bill;
import bootcamp.domain.Client;
import bootcamp.repository.IGenericRepository;

public class BillServiceImp implements IBillService {
    private final IGenericRepository<Bill> billRepository;
    private final IGenericRepository<Client> clientRepository;

    public BillServiceImp(IGenericRepository<Bill> billRepository, IGenericRepository<Client> clientRepository) {
        this.billRepository = billRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void addBill(Bill bill) {
        if (!clientRepository.findById(bill.getClient().getId()).isPresent()){
            clientRepository.save(bill.getClient());
        }
        billRepository.save(bill);
    }
}
