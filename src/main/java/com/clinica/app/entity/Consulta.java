package com.clinica.app.entity;

import com.clinica.core.audit.AuditEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consulta")
public class Consulta extends AuditEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;

    @Column(name = "numero_consultorio", nullable = false)
    private String numeroConsultorio;

    // LocalDate: Solo fechas
    // LocalDateTime: Fechas y Horas.
    @Column(name = "fecha_consulta", nullable = false)
    private LocalDateTime fechaConsulta;

    @Column(name = "detalle_consulta")
    private String detalleConsulta;

    @Column(name = "estado")
    private Boolean estado;

    //Muchas consultas pueden pertenecer a un paciente
    // Esta anotacion afecta a la db porque crea una llave foranea.
    // Para actualizar o eliminar depende del Metodo save o update(si le pasamos el ID)
    @ManyToOne //Foreign key
    @JoinColumn(name = "id_paciente",nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_paciente"))
    @JsonIgnore
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_medico"))
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_especialidad"))
    private Especialidad especialidad;



    //PRIMERA FORMA PARA RELACION MUCHOS A MUCHOS

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "consulta_examen",
//            joinColumns = @JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_examen_consulta")),
//            inverseJoinColumns = @JoinColumn(name = "id_examen", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_examen_examen"))
//    )
//    private List<Examen> listaExamenes;

}
