package dev.src.main.java.com.mario.dev.model;

import java.util.Date;

public class PreTermo extends Crianca{

    private Integer correcaoIdadeGestacionalSemanas;
    private Integer correcaoIdadeGestacionalDias;

    public PreTermo() {
    }

    public PreTermo(String nome, Date dataNascimento, Double pesoEmKg, Integer idadeGestacionalEmSemanas, Integer idadeGestacionalEmDias, Integer correcaoIdadeGestacionalSemanas, Integer correcaoIdadeGestacionalDias) {
        super(nome, dataNascimento, pesoEmKg, idadeGestacionalEmSemanas, idadeGestacionalEmDias);
        this.correcaoIdadeGestacionalSemanas = correcaoIdadeGestacionalSemanas;
        this.correcaoIdadeGestacionalDias = correcaoIdadeGestacionalDias;
    }

    // preTermo < 37 semanas
    public String idadeGestacional(){
        Integer idadeCorretaEmSemanas = 40;
        Integer diferencaIdadeGestacionalSemanas = idadeCorretaEmSemanas - super.getIdadeGestacionalEmSemanas();

        return "preTermo";
    }
}
