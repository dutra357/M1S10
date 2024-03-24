package com.br.FullStack.M1S10.controllers;

import com.br.FullStack.M1S10.Dto.AlunoDto;
import com.br.FullStack.M1S10.entities.AlunoEntity;
import com.br.FullStack.M1S10.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<AlunoEntity>> get() {
        var resultado = service.buscarTodos();
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> post(@RequestBody AlunoEntity newAluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(newAluno));
    }

    //Padrão DTO - teste
    @GetMapping("{id}")
    public ResponseEntity<AlunoDto> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorIdDto(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> put(@PathVariable Long id, @RequestBody AlunoEntity request) {
        return ResponseEntity.ok(service.alterar(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
