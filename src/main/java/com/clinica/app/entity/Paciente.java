package com.clinica.app.entity;

import com.clinica.core.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paciente") //schema = "test" : cambiar de schema(postgres)
public class Paciente extends AuditEntity {

    //@NonNull: Indicamos que no sea nulo, complementado con @RequiredArgsConstructor nos genera con esos campos

    @Id
    //Personaliza el nombre de la secuencia.
    //initialValue: Valor inicial de la secuencia | allocationSize: Incrementar el valor generado
//    @SequenceGenerator(name="paciente_seq", sequenceName="paciente_id_seq", initialValue = 1, allocationSize = 1)
    // Genera un ID autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    public Integer idPaciente;

    @Column(name = "nombre")
    public String nombre;

    // @NotNull
    @Column(name = "edad")
    public Integer edad;

    @Column(name = "apellido_paterno")
    public String apellidoPaterno;

    @Column(name = "apellido_materno")
    public String apellidoMaterno;

    @Column(name = "celular")
    public String celular;

    @Column(name = "dni")
    public String dni;

    @Column(name = "direccion")
    public String direccion;

    @Column(name = "email")
    public String email;

    @Column(name = "estado")
    private Boolean estado;

}
