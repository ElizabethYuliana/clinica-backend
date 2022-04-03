package com.clinica.app.repository;

import com.clinica.app.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    /* ************ CONSULTAS POR METODOS - SpringData ************* */

    //Buscar a un paciente por nombre :: BY
    Optional<Paciente> findByNombre(String nombre);

    //Buscar por nombre y apellidoPaterno :: AND
    Optional<Paciente> findByNombreAndApellidoPaterno(String nombre, String apellidoPaterno);

    // Buscar a los pacientes entre: 18 y 40 años :: BETWEEN
    List<Paciente> findByEdadBetween(Integer edadInicial, Integer edadFinal);

    // Buscar Paacientes cuyos nombren tengan una coincidencia con algunas letras :: LIKE
    List<Paciente> findByNombreLike(String coincidenciaNombre);

    // Buscar a los pacientes entre: 18 y 40 años y Ordenarlos Descendentemente :: BETWEEN :: ORDERBY
    List<Paciente> findByEdadBetweenOrderByEdadDesc(Integer edadInicial, Integer edadFinal);



    /* ************ CONSULTAS POR JPQL (Java Persistence Query Language)************* */

                        /*** Parametros Indexados ****/
    @Query("SELECT p FROM Paciente p WHERE p.nombre = ?1 AND p.apellidoPaterno = ?2")
    Optional<Paciente> buscarNombreYApellidoPaterno(String nombre, String apellidoPaterno);

    // Buscar a los pacientes entre: 18 y 40 años y Ordenarlos Descendentemente
    @Query("SELECT p FROM Paciente p WHERE p.edad BETWEEN ?1 and ?2 order by p.edad desc ")
    List<Paciente> buscaRangoEdadesOrdenados(Integer edadInicial, Integer edadFinal);


    @Query("select p from Paciente p where p.estado = true")
    List<Paciente> findAllActive();

                        /*** Parametros con Nombre ****/

    //Buscar a un paciente por nombre y apellido paterno
    @Query("SELECT p FROM Paciente p WHERE p.nombre = :nombre AND p.apellidoPaterno = :apPaterno")
    Optional<Paciente> buscarNombreYApellidoPaterno2(@Param("nombre") String nombre, @Param("apPaterno") String apellidoPaterno);

    // Buscar a los pacientes entre: 18 y 40 años y Ordenarlos Descendentemente
    @Query("SELECT p FROM Paciente p WHERE p.edad BETWEEN :edadInicial and :edadFinal order by p.edad desc ")
    List<Paciente> buscaRangoEdadesOrdenados2(Integer edadInicial, Integer edadFinal);



    /* ************ CONSULTAS NATIVAS (SQL)************* */

    // Buscar a los pacientes entre: 18 y 40 años y Ordenarlos Descendentemente
    @Query(value = "SELECT * FROM paciente p where p.edad between :edadInicial and :edadFinal order by p.edad desc", nativeQuery = true)
    List<Paciente> buscaRangoEdadesOrdenados3(Integer edadInicial, Integer edadFinal);


}
