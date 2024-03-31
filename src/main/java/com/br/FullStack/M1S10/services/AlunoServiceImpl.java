package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.Dto.AlunoDto;
import com.br.FullStack.M1S10.entities.AlunoEntity;
import com.br.FullStack.M1S10.exceptions.NotFoundException;
import com.br.FullStack.M1S10.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService{
    //Dependencia
    private final AlunoRepository repository;
    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlunoEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Aluno não encontrado com este ID: " + id));
    }



    @Transactional
    public AlunoDto buscarPorIdDto (Long id) {
        //Para acessar o objeto OPTIONAL precisa do get()
        AlunoEntity alunoEntity = repository.findById(id).get();
        return new AlunoDto(alunoEntity);
    }
    @Override
    public List<AlunoDto> buscarTodos() {
        List<AlunoEntity> listDto = repository.findAll();
        return listDto.stream().map(x -> new AlunoDto(x)).collect(Collectors.toList());
    }


    @Override
    public AlunoEntity criar(AlunoEntity entity) {
        return repository.save(entity);
    }

    @Override
    public AlunoEntity alterar(Long id, AlunoEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        AlunoEntity entity = buscarPorId(id);
        repository.delete(entity);

    }
}
