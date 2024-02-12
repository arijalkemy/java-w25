package org.example.repository;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.entity.Localizador;

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
