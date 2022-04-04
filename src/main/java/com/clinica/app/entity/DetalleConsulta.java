package com.clinica.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalle_consulta")
public class DetalleConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_consulta")
    private Integer idDetalleConsulta;

    @Column(name = "diagnostico", nullable = false)
    private String diagnostico;

    @Column(name = "tratamiento", nullable = false)
    private String tratamiento;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_consulta_consulta"))
    @JsonIgnore
    private Consulta consulta;

}
