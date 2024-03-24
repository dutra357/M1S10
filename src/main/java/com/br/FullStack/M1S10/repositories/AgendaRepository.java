package com.br.FullStack.M1S10.repositories;

import com.br.FullStack.M1S10.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
    List<AgendaEntity> findByAlunoIdOrderByData(Long alunoId);

    List<AgendaEntity> findByAlunoIdAndDataGreaterThanOrderByData(Long alunoId, LocalDateTime data);

    List<AgendaEntity> findByTutorIdOrderByData(Long tutorId);

    List<AgendaEntity> findByTutorIdAndDataGreaterThanOrderByData(Long tutorId, LocalDateTime data);
}
