package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private static List<Locator> locators = new ArrayList<>();

    public static void addLocator(Locator locator){
        locators.add(locator);
    }

    public static List<Locator> getLocators() {
        return locators;
    }

    public static Boolean moreOrEqTwoLocators(Client client){
        if(locators.stream().filter(l -> l.getClient().equals(client)).toList().size() >= 2){
            return true;
        }
        return false;
    }

    public static Long locatorsSold(){
        return locators.stream().count();
    }

    public static Integer totalBookings(){
        return locators.stream().mapToInt(l -> l.getProducts().size()).sum();
    }

    public static Map<String,Object> totalClasifiedBookings(){
        Map<String,Object> map = new HashMap<>();
        map.put("hotel", locators.stream().map(l -> l.getProducts()).flatMap(List::stream).filter(p -> p instanceof Hotel).count());
        map.put("boleto", locators.stream().map(l -> l.getProducts()).flatMap(List::stream).filter(p -> p instanceof TravelTicket).count());
        map.put("comida", locators.stream().map(l -> l.getProducts()).flatMap(List::stream).filter(p -> p instanceof Food).count());
        map.put("transporte", locators.stream().map(l -> l.getProducts()).flatMap(List::stream).filter(p -> p instanceof Transport).count());
        return map;
    }

    public static Double totalSold(){
        return locators.stream().mapToDouble(l -> l.getTotal()).sum();
    }

    public static Double averageSold(){
        return locators.stream().mapToDouble(l -> l.getTotal()).sum()/locatorsSold();
    }

    @Override
    public String toString() {
        return "Repository [locators=" + locators + "]";
    }
}
