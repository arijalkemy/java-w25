package org.blog.controller;

import org.blog.dto.response.EntradaBlogDTO;
import org.blog.dto.response.SuccessCreateResponseDTO;
import org.blog.service.EntradaService;
import org.blog.service.IEntradaService;
import org.blog.utils.EntradaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private final IEntradaService blogService;

    @Autowired
    public Controller(EntradaService blogService) {
        this.blogService = blogService;
    }

    /*
    * Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente mostrando su “Id”. (URI: /blog).
    * En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y devolver un mensaje indicando dicha situación.
    * */
    @PostMapping("/blog")
    public ResponseEntity<SuccessCreateResponseDTO> newBlogEntry(@RequestBody EntradaBlogDTO entry) {
        blogService.createBlogEntry(EntradaMapper.fromDTO(entry));

        //Si llega aca "se supone" que se creo. Si no la excepcion se encarga de manejarlo.
        SuccessCreateResponseDTO res = new SuccessCreateResponseDTO("Se ha creado correctamente la entrada de blog con id " + entry.getId());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /*
    * Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo. (URI: /blog/{id}).
      Si el “Id” ingresado no corresponde a ninguna entrada de Blog, indicarlo con un mensaje adecuado.
    * */
    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getBlogEntry(@PathVariable Long id) {
        EntradaBlogDTO res = blogService.getBlogEntryById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).
    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getAllBlogs() {
        List<EntradaBlogDTO> res = blogService.getAllBlogEntries();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
