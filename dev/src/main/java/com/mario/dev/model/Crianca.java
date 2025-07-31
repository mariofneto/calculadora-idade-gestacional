package com.mario.dev.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

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
        return ChronoUnit.DAYS.between(getDataNascimento(), LocalDate.now(ZoneId.of("America/Sao_Paulo")));
    }

    public Integer igcEmDias() {
        int diasParaNascer = getIdadeGestacionalS() * 7 + getIdadeGestacionalD();
        return diasParaNascer + diasVividos().intValue();
    }

    public String igcEmSemanasEDias() {

        if (isPreTermo) {
            long diasVividos = diasVividos();

            int totalDias = igcEmDias();

            long diferencaEmDiasCorrigida = diasVividos - ((40 * 7) - ((getIdadeGestacionalS() * 7) + getIdadeGestacionalD()));

            long semanas = diferencaEmDiasCorrigida / 7;
            long dias = diferencaEmDiasCorrigida - semanas * 7;

            if (getIdadeGestacionalS() < 37) {
                // para ver se é negativo, se sim, pega o valor absoluto
                if(semanas <= 0 && dias <= 0){
                    long somaSemanasDias = (Math.abs(semanas) * 7) + Math.abs(dias);
                    long idadeCorrigida = 280 - somaSemanasDias;

                    String[] res = {};

                    return String.format("%d semanas e %d dias\n\nFaltam %d semanas e %d" +
                                    " dias para corrigir a idade",
                            idadeCorrigida/7, idadeCorrigida % 7, Math.abs(semanas), Math.abs(dias));
                }
                else {
                    return String.format("%d semanas e %d dias", semanas, dias);
                }
            }
            // quando só tem dias, não deu semanas ainda
            else {
                int diasPosTermo = totalDias - 280;
                return String.format("%d dias de vida", diasPosTermo);
            }

        } else {

            Long dias = diasVividos();
            if (dias >= 7) {

                long meses = ChronoUnit.MONTHS.between(getDataNascimento(), LocalDate.now(ZoneId.of("America/Sao_Paulo")));

                // APENAS UM AUXILIAR PARA NO CALCULO DE SEMANAS EXCLUIR O QUE JÁ FOI CONTADO NO MÊS
                LocalDate auxMes = getDataNascimento().plusMonths(meses);

                long semanas = ChronoUnit.DAYS.between(auxMes, LocalDate.now(ZoneId.of("America/Sao_Paulo"))) / 7;
                long diasRestantes = ChronoUnit.DAYS.between(auxMes, LocalDate.now(ZoneId.of("America/Sao_Paulo"))) % 7;

                return String.format("%d meses, %d semanas e %d dias", meses, semanas, diasRestantes);
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
