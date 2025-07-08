package com.mario.dev.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "tb_termo")
public class Termo extends Crianca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long diasVividos;

    public Termo() {
    }

    public Termo(String nome, LocalDate dataNascimento, Double pesoEmKg, Integer idadeGestacionalS, Integer idadeGestacionalD) {
        super(nome, dataNascimento, pesoEmKg, idadeGestacionalS, idadeGestacionalD);
    }

    public Long getId() {
        return id;
    }

    @Override
    public Long diasVividos() {
        LocalDate hoje = LocalDate.now();

        diasVividos = ChronoUnit.DAYS.between(getDataNascimento(), hoje);

        return diasVividos;
    }

    public Long semanasDeVida(){
        return  diasVividos() / 7;
    }

    public Long diasDeVida(){
        return diasVividos() % 7;
    }

    public String semanasEDiasCorrigidos(){
        String msg = "";
        if(semanasDeVida() > 0 && semanasDeVida() < 4){
            msg = String.format("%d semanas e %d dias%n", semanasDeVida(), diasDeVida());
            return msg;
        }
        else if(semanasDeVida() >= 4){
            Long mesesDeVida = diasVividos() / 30;
            Long diasVividos = diasVividos() % 30;

            msg = String.format("%d meses e %d dias%n", mesesDeVida, diasVividos);
            return msg;
        }
        else if(semanasDeVida() == 0){
            msg = String.format("%d dias%n", diasDeVida());
            return msg;
        }
        return msg;
    }
}
