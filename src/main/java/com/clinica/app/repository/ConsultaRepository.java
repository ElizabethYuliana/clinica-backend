package com.clinica.app.repository;

import com.clinica.app.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query("SELECT c FROM Consulta c WHERE c.estado = true")
    List<Consulta> listarConsultaActivo();

    //@Query("SELECT c FROM Consulta c WHERE c.estado = true AND c.idConsulta = :id")
    Optional<Consulta> findByIdConsultaAndAndEstadoIsTrue(Integer idConsulta);
}
