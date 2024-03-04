package covid.Service;

import covid.DTO.PersonaDeRiesgoDTO;
import covid.Model.Persona;
import covid.Model.Sintoma;
import covid.RepositorioSintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Servicios {

    public List<Sintoma> findAll(){
        Sintoma sintoma1 = new Sintoma(1, "fiebre", "alto");
        Sintoma sintoma2 = new Sintoma(2, "tos", "bajo");
        List<Sintoma> listaSintomas = new ArrayList<>();
        listaSintomas.add(sintoma1);
        listaSintomas.add(sintoma2);

        return listaSintomas;
    }

    public String findByName(String nombre) {
        Sintoma sintoma1 = new Sintoma(1, "fiebre", "alto");
        Sintoma sintoma2 = new Sintoma(2, "tos", "bajo");
        List<Sintoma> listaSintomas = new ArrayList<>();
        listaSintomas.add(sintoma1);
        listaSintomas.add(sintoma2);

        Sintoma busqueda = listaSintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);

        if(busqueda != null) {
            return "Nivel de gravedad: " + busqueda.getNivel_de_gravedad();
        } else {
            return null;
        }
    }

    public List<PersonaDeRiesgoDTO> findRiskPerson(){
        Sintoma sintoma1 = new Sintoma(1, "fiebre", "alto");
        Sintoma sintoma2 = new Sintoma(2, "tos", "bajo");
        List<Sintoma> listaSintomas1 = new ArrayList<>();
        listaSintomas1.add(sintoma1);
        listaSintomas1.add(sintoma2);

        List<Sintoma> listaSintomas2 = new ArrayList<>();
        listaSintomas2.add(sintoma1);

        Persona persona1 = new Persona(1, "sergio", "mancilla", 61);
        Persona persona2 = new Persona(2, "gabriel", "agred", 65);
        PersonaDeRiesgoDTO personaDeRiesgoDTO = new PersonaDeRiesgoDTO();
        PersonaDeRiesgoDTO personaDeRiesgoDTO2 = new PersonaDeRiesgoDTO();

        personaDeRiesgoDTO.setNombre(persona1.getNombre());
        personaDeRiesgoDTO.setApellido(persona1.getApellido());
        personaDeRiesgoDTO.setEdad(persona1.getEdad());
        personaDeRiesgoDTO.setListaSintomas(listaSintomas1);

        personaDeRiesgoDTO2.setNombre(persona2.getNombre());
        personaDeRiesgoDTO2.setApellido(persona2.getApellido());
        personaDeRiesgoDTO2.setEdad(persona2.getEdad());
        personaDeRiesgoDTO2.setListaSintomas(listaSintomas2);

        List<PersonaDeRiesgoDTO> listaPersonaDTO = new ArrayList<>();
        listaPersonaDTO.add(personaDeRiesgoDTO);
        listaPersonaDTO.add(personaDeRiesgoDTO2);

        return listaPersonaDTO.stream()
                .filter(persona -> persona.getEdad() > 60)
                .collect(Collectors.toList());



    }
}
