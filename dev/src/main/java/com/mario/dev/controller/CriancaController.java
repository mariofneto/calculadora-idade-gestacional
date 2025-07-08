package com.mario.dev.controller;

import com.mario.dev.model.PreTermo;
import com.mario.dev.model.Termo;
import com.mario.dev.service.PreTermoService;
import com.mario.dev.service.TermoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping
public class CriancaController {

    @Autowired
    PreTermoService preTermoService;

    @Autowired
    TermoService TermoService;


    @GetMapping("/pretermo/{id}")
    public ResponseEntity<String> getPreTermoById(@PathVariable Long id){
        PreTermo pt = preTermoService.getPreTermoId(id).orElseThrow();

        return ResponseEntity.ok().body(pt.semanasEDiasCorrigidos());
    }

    @PostMapping("/pretermo/")
    public ResponseEntity<String> createPreTermo(@RequestBody PreTermo preTermo){

        preTermoService.create(preTermo);

        return ResponseEntity.ok().body("criado");
    }

    @GetMapping("/termo/{id}")
    public ResponseEntity<String> getTermoById(@PathVariable Long id){
        Termo t = TermoService.getTermoId(id).orElseThrow();

        return ResponseEntity.ok().body(t.semanasEDiasCorrigidos());
    }

    @PostMapping("/termo/")
    public ResponseEntity<String> createTermo(@RequestBody Termo termo){

        TermoService.create(termo);

        return ResponseEntity.ok().body("criado");
    }


}
