package com.br.FullStack.M1S10.repositories;

import com.br.FullStack.M1S10.entities.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}
