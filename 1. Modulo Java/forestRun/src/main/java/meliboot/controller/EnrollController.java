package meliboot.controller;

import meliboot.persistence.domain.enroll.Enroll;
import meliboot.persistence.domain.enroll.EnrollDTO;
import meliboot.services.common.interfaces.IService;

import java.util.Set;

public class EnrollController {

    private IService<EnrollDTO, Enroll,Integer> service;

    public EnrollController(IService service){
        this.service = service;
    }

    public boolean CreateEnrroll(EnrollDTO enroll){
        boolean statusOk = true;
        try{
            service.Create(enroll);
        }catch (Exception exception){
            statusOk = false;
        }
        finally {
            return statusOk;
        }
    }

    public Set<Enroll> GetAll(){
        return this.service.getAll();
    }

    public void Delete(int id){
        service.delete(id);
    }

}
