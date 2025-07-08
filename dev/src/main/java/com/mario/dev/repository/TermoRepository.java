package com.mario.dev.repository;

import com.mario.dev.model.Termo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermoRepository extends JpaRepository<Termo, Long> {
}
