package com.br.FullStack.M1S10.services;

import com.br.FullStack.M1S10.entities.AgendaEntity;
import com.br.FullStack.M1S10.entities.AlunoEntity;
import com.br.FullStack.M1S10.entities.TutorEntity;
import com.br.FullStack.M1S10.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AlunoService alunoService;
    private final TutorService tutorService;
    private final AgendaRepository repository;

    public AgendaServiceImpl(AlunoService alunoService, TutorService tutorService, AgendaRepository repository) {
        this.alunoService = alunoService;
        this.tutorService = tutorService;
        this.repository = repository;
    }


    @Override
    public List<AgendaEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public AgendaEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public AgendaEntity criar(AgendaEntity entity) {
        AlunoEntity aluno = alunoService.buscarPorId((entity.getAluno().getId()));
        entity.setAluno(aluno);
        TutorEntity tutor = tutorService.buscarPorId((entity.getAluno().getId()));
        entity.setTutor(tutor);
        return repository.save(entity);
    }

    @Override
    public AgendaEntity alterar(Long id, AgendaEntity entity) {
        AlunoEntity aluno = alunoService.buscarPorId(entity.getAluno().getId());
        entity.setAluno(aluno);
        TutorEntity tutor = tutorService.buscarPorId(entity.getTutor().getId());
        entity.setTutor(tutor);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        AgendaEntity agenda = buscarPorId(id);
        repository.delete(agenda);
    }



    @Override
    public List<AgendaEntity> buscarAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return repository.buscarAlunoOrdemData(alunoId);
    }
    @Override
    public List<AgendaEntity> buscarProximosAlunos(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return repository.buscarAlunoIdMaiorOrdemData(alunoId, LocalDateTime.now());
    }




    @Override
    public List<AgendaEntity> buscarTutorId(Long tutorId) {
        return repository.buscarTutorIdOrdemData(tutorId);
    }

    @Override
    public List<AgendaEntity> buscarProximoTutor(Long tutorId) {
        return repository.buscarTutorIdMaiorOrdemData(tutorId, LocalDateTime.now());
    }
}
