package integracion.p1.series;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public abstract  class Series {
    private int incrementalValue;
    private int initialValue;
    private List<Integer> serie;

    public Series(int incrementalValue){
        this.incrementalValue= incrementalValue;
        this.initialValue=0;
        serie = new ArrayList<>();
        serie.add(this.initialValue);
    }

    public int getNextValue(){
        serie.add(serie.get(serie.size()-1)+incrementalValue);
        return serie.get(serie.size()-1);
    }

    public void restartSerie(){
        this.serie.clear();
        serie.add(this.initialValue);
    }

    public void setInitialValue(int initialValue){
        this.initialValue= initialValue;
        restartSerie();
    }


}
