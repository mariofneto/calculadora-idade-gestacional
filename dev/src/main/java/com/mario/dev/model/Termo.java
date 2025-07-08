package com.mario.dev.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// nao precisa corrigir idade
public class Termo extends Crianca {

    private Long diasVividos;

    public Termo() {
    }

    public Termo(String nome, LocalDate dataNascimento, Double pesoEmKg, Integer idadeGestacionalS, Integer idadeGestacionalD) {
        super(nome, dataNascimento, pesoEmKg, idadeGestacionalS, idadeGestacionalD);
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

    public void semanasEDiasCorrigidos(){
        if(semanasDeVida() > 0 && semanasDeVida() < 4){
            System.out.printf("%d semanas e %d dias pós termo%n", semanasDeVida(), diasDeVida());
        }
        else if(semanasDeVida() >= 4){
            Long mesesDeVida = diasVividos() / 30;
            Long diasVividos = diasVividos() % 30;

            System.out.printf("%d meses e %d dias pós termo%n", mesesDeVida, diasVividos);
        }
        else if(semanasDeVida() == 0){
            System.out.printf("%d dias pós termo%n", diasDeVida());
        }
    }
}
