package integracion.p2.saveropa;

import integracion.p2.saveropa.Base.Closet;
import integracion.p2.saveropa.Base.Clothes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer idCloset;
        List<Clothes> clothesList = new ArrayList<>();
        clothesList.add(new Clothes("nile", "sudadera"));
        clothesList.add(new Clothes("pumna", "pants"));
        clothesList.add(new Clothes("fubu", "Socks"));

        Closet closet = new Closet();
        idCloset = closet.saveClothe(clothesList);
        System.out.println("idCloset = " + idCloset);
        closet.getAllClothes();
        System.out.println(" -------------- ");
        List<Clothes> clothesList2 = new ArrayList<>();
        clothesList2.add(new Clothes("Michi", "sudadera"));
        clothesList2.add(new Clothes("dof", "pants"));
        clothesList2.add(new Clothes("Perry", "Socks"));

        idCloset =closet.saveClothe(clothesList2);
        System.out.println("idCloset = " + idCloset);
        closet.getAllClothes();
    }
}
