package com.mario.dev.repository;

import com.mario.dev.model.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long> {
}
