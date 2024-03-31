package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.Dto.AlunoDto;
import com.br.FullStack.M1S10.entities.AlunoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AlunoService {

    AlunoEntity buscarPorId(Long id);
    AlunoDto buscarPorIdDto(Long id);

    AlunoEntity criar(AlunoEntity entity);

    List<AlunoDto> buscarTodos();

    AlunoEntity alterar(Long id, AlunoEntity entity);

    void excluir(Long id);




}
