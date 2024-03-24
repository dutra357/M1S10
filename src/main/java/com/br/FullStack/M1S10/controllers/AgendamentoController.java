package com.br.FullStack.M1S10.controllers;

import com.br.FullStack.M1S10.entities.AgendaEntity;
import com.br.FullStack.M1S10.services.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {
    private final AgendaService service;


    public AgendamentoController(AgendaService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<AgendaEntity>> get() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("aluno_id/{alunoId}")
    public ResponseEntity<List<AgendaEntity>> getAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(service.buscarAlunoId(alunoId));
    }

    @GetMapping("aluno_id/{alunoId}/futuros")
    public ResponseEntity<List<AgendaEntity>> getProximosAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(service.buscarProximosAlunos(alunoId));
    }

    @GetMapping("tutor_id/{tutorId}")
    public ResponseEntity<List<AgendaEntity>> getTutorId (@PathVariable Long tutorId) {
        return ResponseEntity.ok(service.buscarTutorId(tutorId));
    }

    @GetMapping("tutor_id/{tutorId}/futuros")
    public ResponseEntity<List<AgendaEntity>> getProximosTutorId(@PathVariable Long tutorId) {
        return ResponseEntity.ok(service.buscarProximoTutor(tutorId));
    }

    @PostMapping
    public ResponseEntity<AgendaEntity> post(@RequestBody AgendaEntity request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<AgendaEntity> put(@PathVariable Long id, @RequestBody AgendaEntity alteracao) {
        return ResponseEntity.ok(service.alterar(id, alteracao));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
