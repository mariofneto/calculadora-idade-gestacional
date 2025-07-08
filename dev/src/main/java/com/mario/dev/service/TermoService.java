package com.mario.dev.service;

import com.mario.dev.model.PreTermo;
import com.mario.dev.model.Termo;
import com.mario.dev.repository.TermoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TermoService {

    @Autowired
    private TermoRepository repository;

    public Optional<Termo> getTermoId(Long id){
        return repository.findById(id);
    }

    public String create(Termo Termo){
        repository.save(Termo);
        return "criado";
    }
}
