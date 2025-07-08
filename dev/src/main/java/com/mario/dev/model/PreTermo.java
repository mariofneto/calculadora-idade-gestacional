package com.mario.dev.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// precisa corrigir idade
public class PreTermo extends Crianca{

    // é a diferença de 40 semanas para a idadeGestacional
    private Integer diferencaGestacionalEmDias;

    private Long diasVividos;

    public PreTermo(String nome, LocalDate dataNascimento, Double pesoEmKg, Integer idadeGestacionalS, Integer idadeGestacionalD) {
        super(nome, dataNascimento, pesoEmKg, idadeGestacionalS, idadeGestacionalD);
    }

    @Override
    public Long diasVividos() {
        LocalDate hoje = LocalDate.now();

        diasVividos = ChronoUnit.DAYS.between(getDataNascimento(), hoje);
        diferencaGestacionalEmDias = (40 * 7) - (getIdadeGestacionalS() * 7) - getIdadeGestacionalD();

        Long idadeGestacionalCorrigidaEmDias = diasVividos - diferencaGestacionalEmDias;
        return idadeGestacionalCorrigidaEmDias;
    }

    private Long semanasDeVida(){
        return  diasVividos() / 7;
    }

    private Long diasDeVida(){
        return diasVividos() % 7;
    }

    public void semanasEDiasCorrigidos(){
        // quer dizer que a criança nem chegou no termo, de 40 semanas
        if(diasDeVida() < 0){
            Long resultado = (40 * 7) + diasDeVida();
            Long semanasDeVida = resultado / 7;
            Long diasDeVida = resultado % 7;


            System.out.printf("%d semanas e %d dias pré termo%n", semanasDeVida, diasDeVida);
        }
        else if(semanasDeVida() > 0  && semanasDeVida() < 4){
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
