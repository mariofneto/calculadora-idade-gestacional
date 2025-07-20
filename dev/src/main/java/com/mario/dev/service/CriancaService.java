package com.mario.dev.service;

import com.mario.dev.model.Crianca;
import com.mario.dev.repository.CriancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriancaService {

    @Autowired
    CriancaRepository repository;

    // CRUD COMPLETO

    public List<Crianca> readAllCrianca(){
        return repository.findAll();
    }

    public Crianca readResultById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public Crianca create(Crianca crianca){
        repository.save(crianca);

        return crianca;
    }

    public Crianca update(Long id, Crianca novaCrianca){
        Crianca crianca = repository.findById(id).orElseThrow();

        crianca.setNome(novaCrianca.getNome());
        crianca.setDataNascimento(novaCrianca.getDataNascimento());
        crianca.setIdadeGestacionalS(novaCrianca.getIdadeGestacionalS());
        crianca.setIdadeGestacionalD(novaCrianca.getIdadeGestacionalD());
        crianca.setPreTermo(novaCrianca.isPreTermo());

        repository.save(crianca);

        return crianca;
    }

    public void delete(Long id){
        Crianca crianca = repository.findById(id).orElseThrow();

        repository.delete(crianca);
    }




}
