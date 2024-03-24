package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.entities.MaterialEntity;

import java.util.List;

public interface MaterialService {

    List<MaterialEntity> buscarTodos();

    MaterialEntity buscarPorId(Long id);

    MaterialEntity criar(MaterialEntity material);

    MaterialEntity alterar(Long id, MaterialEntity material);

    void excluir(Long id);
}
