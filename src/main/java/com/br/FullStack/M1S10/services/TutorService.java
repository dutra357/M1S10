package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.entities.TutorEntity;

import java.util.List;

public interface TutorService {

    List<TutorEntity> buscarTodos();
    TutorEntity buscarPorId(Long id);
    TutorEntity criar (TutorEntity entity);
    TutorEntity alterar (Long id, TutorEntity entity);
    void excluir (Long id);

}
