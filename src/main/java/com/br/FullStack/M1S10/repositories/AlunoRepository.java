package com.br.FullStack.M1S10.repositories;

import com.br.FullStack.M1S10.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
