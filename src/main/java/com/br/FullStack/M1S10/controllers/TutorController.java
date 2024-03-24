package com.br.FullStack.M1S10.controllers;

import com.br.FullStack.M1S10.entities.TutorEntity;
import com.br.FullStack.M1S10.services.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutores")
public class TutorController {

    private final TutorService service;
    public TutorController(TutorService service) {
        this.service = service;
    }



    @GetMapping
    public ResponseEntity<List<TutorEntity>> get() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<TutorEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TutorEntity> post(@RequestBody TutorEntity tutor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(tutor));
    }

    @PutMapping("{id}")
    public ResponseEntity<TutorEntity> put(
            @PathVariable Long id, @RequestBody TutorEntity tutor
    ) {
        return ResponseEntity.ok(service.alterar(id, tutor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
