package com.mario.dev.model;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Crianca {

    private String nome;
    private LocalDate dataNascimento;
    private Double pesoEmKg;
    private Integer idadeGestacionalS;
    private Integer idadeGestacionalD;

    public Crianca() {
    }

    public Crianca(String nome, LocalDate dataNascimento, Double pesoEmKg, Integer idadeGestacionalS,
                   Integer idadeGestacionalD) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.pesoEmKg = pesoEmKg;
        this.idadeGestacionalS = idadeGestacionalS;
        this.idadeGestacionalD = idadeGestacionalD;
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

    public Double getPesoEmKg() {
        return pesoEmKg;
    }

    public void setPesoEmKg(Double pesoEmKg) {
        this.pesoEmKg = pesoEmKg;
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

    @Override
    public String toString() {
        return "Crianca{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", pesoEmKg=" + pesoEmKg +
                ", idadeGestacionalEmSemanas=" + idadeGestacionalS +
                ", idadeGestacionalEmDias=" + idadeGestacionalD +
                '}';
    }

    public abstract Long diasVividos();
}
