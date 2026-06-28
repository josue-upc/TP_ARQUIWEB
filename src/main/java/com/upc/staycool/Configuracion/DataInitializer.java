package com.upc.staycool.Configuracion;

import com.upc.staycool.Entidades.RolEntidad;
import com.upc.staycool.Repositorios.RolRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(RolRepositorio rolRepositorio) {
        return args -> {
            // 1. Verificamos y creamos el rol PACIENTE si no existe
            if (rolRepositorio.findByName("PACIENTE").isEmpty()) {
                RolEntidad paciente = new RolEntidad();
                paciente.setName("PACIENTE");
                rolRepositorio.save(paciente);
                System.out.println("--> Rol PACIENTE creado automÃ¡ticamente.");
            }

            // 2. Verificamos y creamos el rol PSICOLOGO si no existe
            if (rolRepositorio.findByName("PSICOLOGO").isEmpty()) {
                RolEntidad psicologo = new RolEntidad();
                psicologo.setName("PSICOLOGO");
                rolRepositorio.save(psicologo);
                System.out.println("--> Rol PSICOLOGO creado automÃ¡ticamente.");
            }
        };
    }
}