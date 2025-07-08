package com.mario.dev.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "tb_pretermo")
public class PreTermo extends Crianca{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // é a diferença de 40 semanas para a idadeGestacional
    private Integer diferencaGestacionalEmDias;

    private Long diasVividos;

    public PreTermo() {
    }

    public PreTermo(String nome, LocalDate dataNascimento, Double pesoEmKg, Integer idadeGestacionalS, Integer idadeGestacionalD) {
        super(nome, dataNascimento, pesoEmKg, idadeGestacionalS, idadeGestacionalD);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiferencaGestacionalEmDias() {
        return diferencaGestacionalEmDias;
    }

    public void setDiferencaGestacionalEmDias(Integer diferencaGestacionalEmDias) {
        this.diferencaGestacionalEmDias = diferencaGestacionalEmDias;
    }

    public Long getDiasVividos() {
        return diasVividos;
    }

    public void setDiasVividos(Long diasVividos) {
        this.diasVividos = diasVividos;
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

    public String semanasEDiasCorrigidos(){
        // quer dizer que a criança nem chegou no termo, de 40 semanas
        if(diasDeVida() < 0){
            Long resultado = (40 * 7) + diasDeVida();
            Long semanasDeVida = resultado / 7;
            Long diasDeVida = resultado % 7;

            String msg = String.format("%d semanas e %d dias pré termo%n", semanasDeVida, diasDeVida);
            return msg;
        }
        else if(semanasDeVida() > 0  && semanasDeVida() < 4){
            String msg = String.format("%d semanas e %d dias pós termo%n", semanasDeVida(), diasDeVida());
            return msg;
        }
        else if(semanasDeVida() >= 4){
            Long mesesDeVida = diasVividos() / 30;
            Long diasVividos = diasVividos() % 30;

            String msg = String.format("%d meses e %d dias pós termo%n", mesesDeVida, diasVividos);
            return msg;
        }
        else if(semanasDeVida() == 0){
            String msg = String.format("%d dias pós termo%n", diasDeVida());
            return msg;
        }
        return "";
    }
}
