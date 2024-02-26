package org.bootcamp.Repository;

import org.bootcamp.model.Locator;

import java.util.ArrayList;
import java.util.List;

public class LocatorRepository {
    private List<Locator> locatorList = new ArrayList<>();

    public LocatorRepository() {
    }

    public void addLocator(Locator locator){
        locatorList.add(locator);
        System.out.println("Se agrego el localizador con exito");
        System.out.println(locator.toString());
    }
    public List<Locator> getLocatorByClient(int idCliente) {
        return locatorList.stream().filter(l-> l.getClient().getIdClient()==idCliente).toList();
    }

    public List<Locator> getLocatorList() {
        return locatorList;
    }

}
