package obras_literarias.controller;

import obras_literarias.dto.ObraLiterariaDto;
import obras_literarias.dto.request.NuevaObraDTO;
import obras_literarias.service.IObrasService;
import obras_literarias.service.ObrasServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraLiterariaController {
    private IObrasService service;

    public ObraLiterariaController(ObrasServiceImp service){
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<?> createObraLiteraria(@RequestBody List<NuevaObraDTO> obras){
        return new ResponseEntity<>(service.saveObrasList(obras), HttpStatus.CREATED);
    }

    //Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaDto>> findByAutor(@PathVariable String autor){
        return new ResponseEntity<>(service.getAllByAutor (autor),HttpStatus.OK);
    }

    //Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    //Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”


/*
[
    {
    "nombre": "Cien años de soledad",
    "autor": "Gabriel Garcia Marquez",
    "paginas": 400,
    "editorial": "Editorial Sudamericana",
    "annoPublicacion": 1967
    },
    {
    "nombre": "El amor en los tiempos del cólera",
    "autor": "Gabriel Garcia Marquez",
    "paginas": 350,
    "editorial": "Editorial Oveja Negra",
    "annoPublicacion": 1985
    },
    {
    "nombre": "Crónica de una muerte anunciada",
    "autor": "Gabriel Garcia Marquez",
    "paginas": 150,
    "editorial": "Editorial Diana",
    "annoPublicacion": 1981
    },
    {
    "nombre": "Don Quijote de la Mancha",
    "autor": "Miguel de Cervantes",
    "paginas": 1000,
    "editorial": "Editorial Planeta",
    "annoPublicacion": 1605
    },
    {
    "nombre": "La sombra del viento",
    "autor": "Carlos Ruiz Zafon",
    "paginas": 500,
    "editorial": "Editorial Planeta",
    "annoPublicacion": 2001
    },
    {
    "nombre": "El juego del angel",
    "autor": "Carlos Ruiz Zafon",
    "paginas": 600,
    "editorial": "Editorial Planeta",
    "annoPublicacion": 2008
    },
    {
    "nombre": "El laberinto de los espiritus",
    "autor": "Carlos Ruiz Zafon",
    "paginas": 800,
    "editorial": "Editorial Planeta",
    "annoPublicacion": 2016
    },
    {
    "nombre": "Harry Potter y la piedra filosofal",
    "autor": "J.K. Rowling",
    "paginas": 300,
    "editorial": "Bloomsbury Publishing",
    "annoPublicacion": 1997
    },
    {
    "nombre": "Harry Potter y la cámara de los secretos",
    "autor": "J.K. Rowling",
    "paginas": 350,
    "editorial": "Bloomsbury Publishing",
    "annoPublicacion": 1998
    },
    {
    "nombre": "Harry Potter y el prisionero de Azkaban",
    "autor": "J.K. Rowling",
    "paginas": 400,
    "editorial": "Bloomsbury Publishing",
    "annoPublicacion": 1999
    }
]
 */
}
