package com.br.FullStack.M1S10.controllers;

import com.br.FullStack.M1S10.entities.AgendaEntity;
import com.br.FullStack.M1S10.services.AgendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("agendamento")
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
}
