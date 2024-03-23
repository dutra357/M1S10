package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.entities.AlunoEntity;
import com.br.FullStack.M1S10.repositories.AlunoRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService{

    //Dependencia
    private final AlunoRepository repository;
    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }


    @Override
    public AlunoEntity buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<AlunoEntity> buscarTodos() {
        return null;
    }

    @Override
    public AlunoEntity criar(AlunoEntity entity) {
        return repository.save(entity);
    }

    @Override
    public AlunoEntity alterar(Long id, AlunoEntity entity) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
