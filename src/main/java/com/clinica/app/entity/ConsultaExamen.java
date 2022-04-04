package com.clinica.app.entity;

import com.clinica.app.entity.fk.ConsultaExamenPK;
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
@Table(name = "consulta_examen")
//@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen {

    //Obliga id
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_examen_consulta"))
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "id_examen", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_examen_examen"))
    private Examen examen;

//    @Id
//    private Consulta consulta;
//
//    @Id
//    private Examen examen;

}
