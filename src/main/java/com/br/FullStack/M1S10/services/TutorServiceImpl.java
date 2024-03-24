package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.entities.TutorEntity;
import com.br.FullStack.M1S10.exceptions.NotFoundException;
import com.br.FullStack.M1S10.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepository repository; //interface
    public TutorServiceImpl(TutorRepository repository) {
        this.repository = repository;
    }



    @Override
    public List<TutorEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public TutorEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public TutorEntity criar(TutorEntity entity) {
        return repository.save(entity);
    }

    @Override
    public TutorEntity alterar(Long id, TutorEntity entity) {
        buscarPorId(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        TutorEntity entity = buscarPorId(id);
        repository.delete(entity);

    }
}
