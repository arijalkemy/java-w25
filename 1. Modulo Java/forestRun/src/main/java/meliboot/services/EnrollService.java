package meliboot.services;



import meliboot.persistence.common.IRepository;
import meliboot.persistence.domain.enroll.Enroll;
import meliboot.persistence.domain.enroll.EnrollDTO;
import meliboot.services.common.interfaces.IService;

import java.util.Set;

public class EnrollService implements IService<EnrollDTO, Enroll,Integer> {

    private IRepository<EnrollDTO,Enroll,Integer> repository;

    public  EnrollService(IRepository repository){
        this.repository = repository;
    }
    @Override
    public EnrollDTO Create(EnrollDTO enrollDTO) {
        return this.repository.Add(enrollDTO);
    }

    @Override
    public Set<Enroll> getAll() {
        return repository.getAll();
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(integer);
    }
}
