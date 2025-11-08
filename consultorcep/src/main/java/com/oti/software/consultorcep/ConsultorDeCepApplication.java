package com.oti.software.consultorcep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultorDeCepApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultorDeCepApplication.class, args);
        
        System.out.println("Olá, bem-vindo à API de consulta CEP da OTI Software.");
        System.out.println("Esses são os CEPs cadastrados no banco de dados para facilitar a consulta:\n");
        System.out.println("69900-100");
        System.out.println("69901-200");
        System.out.println("69902-300");
        System.out.println("01001-000");
        System.out.println("01010-000");
        System.out.println("20040-020");
        System.out.println("20010-000");
        System.out.println("30110-000");
        System.out.println("40010-000");
        System.out.println("70040-010");
        System.out.println("88058-001");
        System.out.println("\nO ConsultorCEP está rodando em http://localhost:8080/");
    }
}
