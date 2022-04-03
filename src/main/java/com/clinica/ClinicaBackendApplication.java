package com.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//Escaner de componentes: Escanear las clases que esten fuera de la clase Inicia, (@Service, @Repository, etc) para poder manejar la inyeccion de depencia
public class ClinicaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaBackendApplication.class, args);
    }

}
