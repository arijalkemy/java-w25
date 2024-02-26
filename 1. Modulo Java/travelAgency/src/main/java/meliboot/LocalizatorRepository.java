package meliboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalizatorRepository {
    private static LocalizatorRepository instance;
    private List<Localizator> localizators;

    private LocalizatorRepository(){
        localizators = new ArrayList<>();
    }


    public static LocalizatorRepository getInstance(){
        if(instance == null){
            instance = new LocalizatorRepository();
        }
        return instance;
    }

    public void  Add(Localizator localizator){
        this.localizators.add(localizator);
    }

    public List<Localizator> getAll(){
        return List.copyOf(localizators);
    }
}
