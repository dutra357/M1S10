package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.entities.MaterialEntity;
import com.br.FullStack.M1S10.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService{
    private final MaterialRepository repository;

    public MaterialServiceImpl(MaterialRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<MaterialEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public MaterialEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public MaterialEntity criar(MaterialEntity material) {
        return repository.save(material);
    }

    @Override
    public MaterialEntity alterar(Long id, MaterialEntity material) {
        return repository.save(material);
    }

    @Override
    public void excluir(Long id) {
        MaterialEntity material = buscarPorId(id);
        repository.delete(material);
    }
}
