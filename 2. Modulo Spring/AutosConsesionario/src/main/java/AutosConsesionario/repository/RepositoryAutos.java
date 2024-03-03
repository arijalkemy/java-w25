package AutosConsesionario.repository;

import AutosConsesionario.entity.Auto;
import AutosConsesionario.entity.Service;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositoryAutos implements IRpositoryAutos{
    List<Auto> listAutos;

    @Override
    public List<Auto> AllAutos() {
        this.listAutos = loadData();
        return listAutos;
    }

    public List<Auto> loadData(){
        List<Service> listService= List.of(new Service("2023-05-20", "10000","Oil change and filter replacement"),
        new Service("2022-12-10", "10000", "Tire rotation and wheel alignment"),
        new Service("2023-06-18", "3000", "Oil change and filter replacement"),
        new Service("2021-07-20", "20000", "Transmission fluid change"));

        List<Auto> listAuto= List.of(
                new Auto(1,"Chevrolet", "Cruze", "2020-11-03", 30000, 4, 15000.0, "USD", listService.get(0),3),
                new Auto(2,"Honda", "Civic", "2021-09-28", 20000, 4, 18000.0, "USD", listService.get(1),2),
                new Auto(3,"Ford", "Focus", "2023-02-12", 5000, 4, 22000.0, "USD",listService.get(2),1),
                new Auto(4,"Chevrolet", "Cruze", "2020-11-03", 30000, 4, 15000.0, "USD",listService.get(3),3));
        return listAuto;
    }
}
