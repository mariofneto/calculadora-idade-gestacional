package dev.src.main.java.com.mario.dev.model;

import java.util.Date;

public abstract class Crianca {

    private String nome;
    private Date dataNascimento;
    private Double pesoEmKg;
    private Integer idadeGestacionalEmSemanas;
    private Integer idadeGestacionalEmDias;

    public Crianca() {
    }

    public Crianca(String nome, Date dataNascimento, Double pesoEmKg, Integer idadeGestacionalEmSemanas, Integer idadeGestacionalEmDias) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.pesoEmKg = pesoEmKg;
        this.idadeGestacionalEmSemanas = idadeGestacionalEmSemanas;
        this.idadeGestacionalEmDias = idadeGestacionalEmDias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getPesoEmKg() {
        return pesoEmKg;
    }

    public void setPesoEmKg(Double pesoEmKg) {
        this.pesoEmKg = pesoEmKg;
    }

    public Integer getIdadeGestacionalEmSemanas() {
        return idadeGestacionalEmSemanas;
    }

    public void setIdadeGestacionalEmSemanas(Integer idadeGestacionalEmSemanas) {
        this.idadeGestacionalEmSemanas = idadeGestacionalEmSemanas;
    }

    public Integer getIdadeGestacionalEmDias() {
        return idadeGestacionalEmDias;
    }

    public void setIdadeGestacionalEmDias(Integer idadeGestacionalEmDias) {
        this.idadeGestacionalEmDias = idadeGestacionalEmDias;
    }

    @Override
    public String toString() {
        return "Crianca{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", pesoEmKg=" + pesoEmKg +
                ", idadeGestacionalEmSemanas=" + idadeGestacionalEmSemanas +
                ", idadeGestacionalEmDias=" + idadeGestacionalEmDias +
                '}';
    }
}
