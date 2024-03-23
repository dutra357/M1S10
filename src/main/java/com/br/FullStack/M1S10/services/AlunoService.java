package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.entities.AlunoEntity;

public interface AlunoService {

    List<AlunoEntity> buscarTodos();
    List<AlunoEntity> buscarPorId(Long id);
    List<AlunoEntity> criar(AlunoEntity entity);
    List<AlunoEntity> alterar(Long id, AlunoEntity entity);





}
