package com.mario.dev.controller;

import com.mario.dev.model.PreTermo;
import com.mario.dev.model.Termo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping
public class CriancaController {


    @GetMapping("/pretermo")
    public String getPreTermo(){
        PreTermo pt1 = new PreTermo("Abner", LocalDate.of(2025, 06, 21), 2.5, 36, 6);
        //Termo t1 = new Termo("José Henrique", LocalDate.of(2025, 06, 11), 2.5, 39, 0);

        pt1.semanasEDiasCorrigidos();
        //t1.semanasEDiasCorrigidos();

        return "ok";
    }
}
