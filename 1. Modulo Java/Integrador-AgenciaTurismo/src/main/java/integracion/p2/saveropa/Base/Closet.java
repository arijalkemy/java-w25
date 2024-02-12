package integracion.p2.saveropa.Base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class  Closet {
    private Map<Integer, List<Clothes>> dicCloset;
    private Integer idIncremental;

    public Closet() {
        this.dicCloset = new HashMap<>();
        this.idIncremental = 0;
    }

    public Integer saveClothe(List<Clothes> clothesList){
        this.idIncremental++;
        this.dicCloset.put(this.idIncremental, clothesList);
        return  this.idIncremental;
    }
    
    public void getAllClothes(){
        dicCloset.forEach((k,v)-> System.out.println("id = "+ k + " clothes= " + v.toString()));
    }
}
