package com.mario.dev.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "tb_criancas")
public class Crianca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private Integer idadeGestacionalS;

    private Integer idadeGestacionalD;

    private boolean isPreTermo;

    public Crianca() {
    }

    public Crianca(Long id, String nome, LocalDate dataNascimento, Integer idadeGestacionalS,
                   Integer idadeGestacionalD, Boolean isPreTermo) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idadeGestacionalS = idadeGestacionalS;
        this.idadeGestacionalD = idadeGestacionalD;
        this.isPreTermo = idadeGestacionalS != null && idadeGestacionalS < 37;
    }

    @PrePersist
    @PreUpdate
    public void calcularPreTermo() {
        this.isPreTermo = idadeGestacionalS != null && idadeGestacionalS < 37;
    }

    public Long diasVividos() {
        return ChronoUnit.DAYS.between(getDataNascimento(), LocalDate.now());
    }

    public Integer igcEmDias() {
        int diasParaNascer = getIdadeGestacionalS() * 7 + getIdadeGestacionalD();
        return diasParaNascer + diasVividos().intValue();
    }

    public String igcEmSemanasEDias() {
        if (isPreTermo) {
            int totalDias = igcEmDias();
            int semanas = totalDias / 7;
            int dias = totalDias % 7;

            if (getIdadeGestacionalS() < 37) {
                return String.format("%d semanas e %d dias (pré-termo)", semanas, dias);
            } else if (getIdadeGestacionalS() <= 40) {
                return String.format("%d semanas e %d dias (a termo)", semanas, dias);
            } else {
                int diasPosTermo = totalDias - 280;
                return String.format("%d dias pós-termo", diasPosTermo);
            }

        } else {
            Long dias = diasVividos();
            if (dias >= 7) {
                long semanas = dias / 7;
                long diasRestantes = dias % 7;
                return String.format("%d semanas e %d dias (a termo)", semanas, diasRestantes);
            } else {
                return String.format("%d dias de vida", dias);
            }
        }
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdadeGestacionalS() {
        return idadeGestacionalS;
    }

    public void setIdadeGestacionalS(Integer idadeGestacionalS) {
        this.idadeGestacionalS = idadeGestacionalS;
    }

    public Integer getIdadeGestacionalD() {
        return idadeGestacionalD;
    }

    public void setIdadeGestacionalD(Integer idadeGestacionalD) {
        this.idadeGestacionalD = idadeGestacionalD;
    }

    public boolean isPreTermo() {
        return isPreTermo;
    }

    public void setPreTermo(boolean preTermo) {
        isPreTermo = preTermo;
    }
}
