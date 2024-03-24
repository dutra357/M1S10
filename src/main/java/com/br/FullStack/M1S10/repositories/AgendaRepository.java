package com.br.FullStack.M1S10.repositories;

import com.br.FullStack.M1S10.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
    List<AgendaEntity> buscarAlunoOrdemData(Long alunoId);

    List<AgendaEntity> buscarAlunoIdMaiorOrdemData(Long alunoId, LocalDateTime data);

    List<AgendaEntity> buscarTutorIdOrdemData(Long tutorId);

    List<AgendaEntity> buscarTutorIdMaiorOrdemData(Long tutorId, LocalDateTime data);
}
