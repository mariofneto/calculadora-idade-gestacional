package dev.src.main.java.com.mario.dev.model;

import java.util.Date;

public class Termo extends Crianca{

    private Integer diasDeVida;

    public Termo(Integer diasDeVida) {
        this.diasDeVida = diasDeVida;
    }

    public Termo(String nome, Date dataNascimento, Double pesoEmKg, Integer idadeGestacionalEmSemanas, Integer idadeGestacionalEmDias, Integer diasDeVida) {
        super(nome, dataNascimento, pesoEmKg, idadeGestacionalEmSemanas, idadeGestacionalEmDias);
        this.diasDeVida = diasDeVida;
    }

    public String diasDeVida(){
        return String.valueOf(diasDeVida);
    }
}
