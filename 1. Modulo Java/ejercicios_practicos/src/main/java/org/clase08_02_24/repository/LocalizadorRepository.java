package org.clase08_02_24.repository;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.clase08_02_24.entity.Localizador;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocalizadorRepository {
    List<Localizador> localizadorList = new ArrayList<>();
    public boolean addLocalizador(Localizador localizador){
        return localizadorList.add(localizador);
    }
    public boolean removeLocalizador(int id){
        return localizadorList.removeIf(localizador -> localizador.getId()==id);
    }
}
