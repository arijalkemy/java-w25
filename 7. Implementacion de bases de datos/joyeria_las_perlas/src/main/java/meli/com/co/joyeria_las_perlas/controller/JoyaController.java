package meli.com.co.joyeria_las_perlas.controller;

import meli.com.co.joyeria_las_perlas.dto.request.JoyaDto;
import meli.com.co.joyeria_las_perlas.dto.response.MessageDto;
import meli.com.co.joyeria_las_perlas.dto.response.SavedJoyaDto;
import meli.com.co.joyeria_las_perlas.service.JoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jewellery")
public class JoyaController {

    private final JoyaService joyaService;

    public JoyaController(JoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @GetMapping
    public ResponseEntity<List<JoyaDto>> getAll() {
        return ResponseEntity.ok(joyaService.getAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<JoyaDto> getById(@RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(joyaService.getById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<SavedJoyaDto> create(@RequestBody JoyaDto joyaDto) {
        return ResponseEntity.ok().body(joyaService.create(joyaDto));
    }

    @PutMapping("/update")
    public ResponseEntity<SavedJoyaDto> update(@RequestBody JoyaDto joyaDto, @RequestParam Long id) {
        return ResponseEntity.ok().body(joyaService.update(joyaDto, id));
    }

    @DeleteMapping
    public ResponseEntity<MessageDto> delete(@RequestParam Long id) {
        return ResponseEntity.ok(joyaService.delete(id));
    }


}
