package com.br.FullStack.M1S10.repositories;

import com.br.FullStack.M1S10.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}
