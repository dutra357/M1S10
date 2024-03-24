package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.entities.AgendaEntity;

import java.util.List;

public interface AgendaService {

    List<AgendaEntity> burscarTodos();

    AgendaEntity buscarPorId(Long id);

    AgendaEntity criar(AgendaEntity entity);

    AgendaEntity alterar(Long id, AgendaEntity entity);

    void excluir(Long id);

    List<AgendaEntity> buscarAlunoId(Long alunoId);

    List<AgendaEntity> buscarProximosAlunos(Long alunoId);

    List<AgendaEntity> buscarTutorId(Long tutorId);

    List<AgendaEntity> buscarProximoTutor(Long tutorId);

}


