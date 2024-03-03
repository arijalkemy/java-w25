package AutosConsesionario.service;

import AutosConsesionario.dto.DtoAuto;
import AutosConsesionario.entity.Auto;
import AutosConsesionario.repository.IRpositoryAutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceAutos implements IServiceAutos{

    @Autowired
    IRpositoryAutos repositoryAutos;

    @Override
    public List<DtoAuto> viewAllAutos() {
        List<Auto> listAutos = repositoryAutos.AllAutos();
        return listAutos.stream()
                .map(this::convertAutotoDto)
                .collect(Collectors.toList());
    }
    private DtoAuto convertAutotoDto(Auto v){
        return new DtoAuto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getManufacturingDate(),
                v.getNumberOfKilometers(),
                v.getPrice(),
                v.getServices());
    }

    @Override
    public boolean exitsAuto(int idAuto) {
        List<Auto> listAutos = repositoryAutos.AllAutos();
        boolean existAuto= listAutos.stream()
                .anyMatch( vh -> vh.getId()==idAuto);
        return existAuto;
    }

    @Override
    public void addAuto(Auto auto) {
        List<Auto> listAutos = repositoryAutos.AllAutos();
        listAutos.add(auto);
    }
}
