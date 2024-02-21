package ejercicio.blog.demo.controller;

import ejercicio.blog.demo.dto.EntradaDTO;
import ejercicio.blog.demo.dto.response.EntradaResponse;
import ejercicio.blog.demo.repository.EntradaRepositorioImp;
import ejercicio.blog.demo.service.EntradaServicio;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    EntradaServicio entradaServ;

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaDTO>> getBlogs() {
        return new ResponseEntity<>(entradaServ.getBlogs(), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<EntradaResponse> publicar(@RequestBody EntradaDTO entrada) {
        entradaServ.guardarPubli(entrada);
        EntradaResponse resp = new EntradaResponse("Se ha publicado correctamente.", entrada.getId());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaDTO> getBlog(@PathVariable String id) {
        Integer realId = Integer.valueOf(id);
        return new ResponseEntity<>(entradaServ.getPubliById(realId), HttpStatus.OK);
    }
}
