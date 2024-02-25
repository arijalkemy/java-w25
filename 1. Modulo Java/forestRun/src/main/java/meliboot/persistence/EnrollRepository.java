package meliboot.persistence;


import meliboot.persistence.common.IAdapter;
import meliboot.persistence.common.IRepository;
import meliboot.persistence.domain.enroll.Enroll;
import meliboot.persistence.domain.enroll.EnrollDTO;

import java.util.HashSet;
import java.util.Set;

public class EnrollRepository implements IRepository<EnrollDTO,Enroll,Integer> {
    private Set<Enroll> entities = new HashSet();
    private static int enrollNumberGeneratorAutoIncrementer = 1;

    private IAdapter<EnrollDTO,Enroll,Integer> adapter;

    public EnrollRepository(IAdapter adapter){
        this.adapter = adapter;
    }
    @Override
    public EnrollDTO Add(EnrollDTO enrollDTO) {
        Enroll enroll = this.adapter.GetModel(enrollDTO,enrollNumberGeneratorAutoIncrementer);
        if(entities.stream().anyMatch(element -> element.isTheSameParticipantInTheSameCategory(enroll))){
            throw new Error("Can't regist the same participant at two times at the same category");
        }
        entities.add(enroll);
        ++enrollNumberGeneratorAutoIncrementer;
        return enrollDTO;
    }

    @Override
    public void delete(Integer id) {
        this.entities.stream().filter(element -> element.getEnrollNumber() == id);
    }

    @Override
    public Set<Enroll> getAll() {
        return this.entities;
    }
}
