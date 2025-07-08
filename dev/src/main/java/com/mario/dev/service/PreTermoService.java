package com.mario.dev.service;

import com.mario.dev.model.PreTermo;
import com.mario.dev.repository.PreTermoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PreTermoService {

    @Autowired
    private PreTermoRepository repository;

    public Optional<PreTermo> getPreTermoId(Long id){
        return repository.findById(id);
    }

    public String create(PreTermo preTermo){
        repository.save(preTermo);
        return "criado";
    }


}
