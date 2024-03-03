package Covid.controller;

import Covid.dto.DtoInfectados;
import Covid.models.Persona;
import Covid.models.Sintoma;
import Covid.service.ServiceCovid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/covid")
public class ControllerCovid {

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Sintoma> getSintomas(){
        ServiceCovid servicio = new ServiceCovid();
        return servicio.getSintomasList();
    }

    @GetMapping("/findSymptom/{name}")
    public String getSitomaGravedad(@PathVariable String name){
        ServiceCovid service = new ServiceCovid();
        List<Sintoma> sintomasList = service.getSintomasList();
        Optional<String> gravedadSintoma= sintomasList.stream()
                .filter( sintoma -> sintoma.getNombre().equals(name))
                .map(Sintoma::getNivelGravedad).findFirst();
        String gravedad = gravedadSintoma.orElse("Sintoma no encontrado");
        return "El nivel del sintoma "+name+" es: "+gravedad;
    }

    @GetMapping("/findRiskPerson")
    @ResponseBody
    public List<DtoInfectados> getPersonaRiesgo(){
        ServiceCovid service = new ServiceCovid();
        List<Persona> personas = service.getPersonasList();
        List<Sintoma> sintomas = service.getSintomasList();

        List<DtoInfectados> infectados = List.of(
                    new DtoInfectados(personas.get(0).getNombre()+personas.get(0).getApellido(),personas.get(0).getEdad(),sintomas.get(3).getNombre()),
                new DtoInfectados(personas.get(1).getNombre()+personas.get(1).getApellido(),personas.get(1).getEdad(),sintomas.get(4).getNombre()),
                new DtoInfectados(personas.get(2).getNombre()+personas.get(2).getApellido(),personas.get(2).getEdad(),sintomas.get(1).getNombre()),
                new DtoInfectados(personas.get(3).getNombre()+personas.get(3).getApellido(),personas.get(3).getEdad(),sintomas.get(2).getNombre()));

        List<DtoInfectados> personasMayores= infectados.stream().filter( persona -> persona.getEdad()>= 60).collect(Collectors.toList());

        return personasMayores;
    }
}
