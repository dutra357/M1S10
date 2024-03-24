package com.br.FullStack.M1S10.controllers;

import com.br.FullStack.M1S10.entities.MaterialEntity;
import com.br.FullStack.M1S10.services.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materiais")
public class MaterialController {
    private final MaterialService service;


    public MaterialController(MaterialService materialService) {
        this.service = materialService;
    }

    @GetMapping
    public ResponseEntity<List<MaterialEntity>> get(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<MaterialEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MaterialEntity> post(@RequestBody MaterialEntity material) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(material));
    }

    @PutMapping("{id}")
    public ResponseEntity<MaterialEntity> put(@PathVariable Long id, @RequestBody MaterialEntity material) {
        return ResponseEntity.ok().body(service.alterar(id, material));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.excluir(id);
        return null;
    }
}
