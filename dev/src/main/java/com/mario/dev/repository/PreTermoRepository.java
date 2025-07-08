package com.mario.dev.repository;

import com.mario.dev.model.PreTermo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreTermoRepository extends JpaRepository<PreTermo, Long> {
}
