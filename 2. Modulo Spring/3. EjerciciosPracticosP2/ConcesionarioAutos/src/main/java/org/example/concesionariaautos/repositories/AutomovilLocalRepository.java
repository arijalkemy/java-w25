package org.example.concesionariaautos.repositories;

import org.example.concesionariaautos.models.Automovil;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AutomovilLocalRepository implements AutomovilRepository{

    private List<Automovil> listaAutomoviles;

    public AutomovilLocalRepository() {
        listaAutomoviles = new ArrayList<>();
    }

    @Override
    public List<Automovil> getAll() {
        return listaAutomoviles;
    }

    @Override
    public Automovil getById(String id) {
        return listaAutomoviles.stream().filter(auto -> auto.getId().equals(id) ).findFirst().orElse(null);
    }

    @Override
    public List<Automovil> getByDate(String since, String to) {
        return listaAutomoviles.stream().filter(auto -> {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            try {
                Date sinceDate = formato.parse(since);
                Date toDate = formato.parse(to);
                Date autoDate = formato.parse(auto.getFechaCreacion());
                return autoDate.after(sinceDate) && autoDate.before(toDate);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } ).toList();
    }

    @Override
    public List<Automovil> getByPrice(String since, String to) {
        return listaAutomoviles.stream().filter(auto -> {
            double autoPrecio = auto.getPrecio();
            return Double.parseDouble(since) <= autoPrecio && autoPrecio <= Double.parseDouble(to);
        }).toList();
    }

    @Override
    public void addAutomovil(Automovil automovil) {
        listaAutomoviles.add(automovil);
    }
}
