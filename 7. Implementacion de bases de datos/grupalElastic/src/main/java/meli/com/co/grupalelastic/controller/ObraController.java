package meli.com.co.grupalelastic.controller;


import meli.com.co.grupalelastic.dto.ObraLiterariaDto;
import meli.com.co.grupalelastic.service.interfaces.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    @Autowired
    IObraLiterariaService service;

    @GetMapping("/authors")
    public ResponseEntity<?> getAuthors(@RequestParam("name") String name) {
        return ResponseEntity.ok(service.getAllByAutor(name));
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks(@RequestParam(value = "keyword", required = false) String keyword,
                                      @RequestParam(value = "beforeYear", required = false) String beforeYear,
                                      @RequestParam(value = "publisher", required = false) String publisher
    ) {
        List<ObraLiterariaDto> books;
        if (keyword != null) {
            books = service.getAllByTitleLike(keyword);
        } else if (beforeYear != null) {
            books = service.getAllBeforeAnio(Integer.parseInt((beforeYear)));
        } else if (publisher != null) {
            books = service.getALlByEditorial(publisher);
        } else {
            books = service.getAll();
        }

        return ResponseEntity.ok(books);
    }

    @GetMapping("top_five_with_more_pages")
    public ResponseEntity<?> getTop5BooksWithMorePages() {
        return  ResponseEntity.ok(null);
    }

    @PostMapping("")
    public ResponseEntity<?> saveObra (@RequestBody ObraLiterariaDto obraLiterariaDto){
        return  new ResponseEntity<>(service.saveObra(obraLiterariaDto), HttpStatus.OK);
    }

}
