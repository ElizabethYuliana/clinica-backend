package com.clinica.app.entity;

import com.clinica.core.audit.AuditEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "numero_consultorio")
    private String numeroConsultorio;

    // LocalDate: Solo fechas
    // LocalDateTime: Fechas y Horas.
    @Column(name = "fecha_consulta")
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
    private Paciente paciente;

}
