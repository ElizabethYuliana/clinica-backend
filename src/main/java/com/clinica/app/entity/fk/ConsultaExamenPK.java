package com.clinica.app.entity.fk;


import com.clinica.app.entity.Consulta;
import com.clinica.app.entity.Examen;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

//@Embeddable
public class ConsultaExamenPK implements Serializable {

//    @ManyToOne
//    @JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_examen_consulta"))
//    private Consulta consulta;
//
//    @ManyToOne
//    @JoinColumn(name = "id_examen", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_examen_examen"))
//    private Examen examen;

}
