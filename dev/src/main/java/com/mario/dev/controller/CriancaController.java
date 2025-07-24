package com.mario.dev.controller;

import com.mario.dev.model.Crianca;
import com.mario.dev.service.CriancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class CriancaController {

    @Autowired
    CriancaService service;

    @GetMapping
    public ResponseEntity<List<Crianca>> readAllCrianca(){
        return ResponseEntity.ok(service.readAllCrianca());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crianca> getById(@PathVariable Long id){
        Crianca c = service.readResultById(id);

        return ResponseEntity.ok(c);
    }

    @GetMapping("/res/{id}")
    public ResponseEntity<String> readResultById(@PathVariable Long id){
        Crianca c = service.readResultById(id);

        return ResponseEntity.ok(c.igcEmSemanasEDias());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Crianca crianca){

        service.create(crianca);

        return ResponseEntity.ok().body("criado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crianca> update(@PathVariable Long id, Crianca crianca){
        Crianca c = service.update(id, crianca);

        return  ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return null;
    }





}
