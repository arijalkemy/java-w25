package meliboot.persistence.domain.enroll;


import meliboot.persistence.common.IAdapter;

public class EnrollMapper implements IAdapter<EnrollDTO,Enroll,Integer> {
    public Enroll GetModel(EnrollDTO enroll,Integer id){
        return new Enroll(enroll.participant(),enroll.category(),id);
    }
}
