package integracion.p1.agencia.repo;


import integracion.p1.agencia.base.Locator;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public class LocatorRepo {
    private List<Locator> locatorList= new ArrayList<>();

    public Locator addLocator(Locator locator){
        double discount = isDiscountAvailable( locator.getClient().getDni()) ? 0.1: 0;
        if (discount > 0){
            System.out.println("apply golden member discount ");
            locator.setPrice(locator.getPrice() - (locator.getPrice()*discount));
        }
        this.locatorList.add(locator);
        return  locator;
    }

    private boolean isDiscountAvailable(int dni){
        return locatorList.stream().filter(x-> x.getClient().getDni() == dni).count() >1;
    }

    public long countLocatorSold(){
        return locatorList.size();
    }

    public long countBooking(){
        return locatorList.stream().mapToLong(x -> x.getBookingList().size()).sum();
    }

    public  void  groupByBooking(){
        locatorList.stream().collect(Collectors.groupingBy(Locator::getBookingList));
    }
    public double totalSells(){
        return locatorList.stream().mapToDouble(Locator::getPrice).sum();
    }
    public double avgSells(){
        return locatorList.stream().mapToDouble(Locator::getPrice).average().orElse(0);
    }

}
