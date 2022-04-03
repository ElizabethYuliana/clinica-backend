package com.clinica;

import com.clinica.core.util.GenericUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ClinicaBackendApplicationTests {

    @Test
    void probarFormato(){
        System.out.println(GenericUtil.formaDate(LocalDateTime.now(), "dd/MM/yyyy HH:mm"));
        System.out.println(GenericUtil.formaDate(LocalDateTime.now(), "dd/MMM/yyyy HH:mm"));
        System.out.println(GenericUtil.formaDate(LocalDateTime.now(), "dd-MMMM-yyyy HH:mm"));
        System.out.println(GenericUtil.formaDate(LocalDateTime.now(), "EEEE/MM/yyyy HH:mm"));
        System.out.println(GenericUtil.formaDate(LocalDateTime.now(), "dd/MM/yyyy HH:mm a"));

        System.out.println(GenericUtil.getCurrentDateByRegion());
    }
}
