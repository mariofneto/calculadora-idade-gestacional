package com.mario.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class CalculadoraIdadeGestacionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraIdadeGestacionalApplication.class, args);
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

}
