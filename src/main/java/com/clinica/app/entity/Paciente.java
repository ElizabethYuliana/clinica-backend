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
import java.util.List;

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

    @Column(name = "nombre", nullable = false, length = 100)
    public String nombre;

    // @NotNull
    @Column(name = "edad", nullable = false)
    public Integer edad;

    @Column(name = "apellido_paterno", nullable = false, length = 50)
    public String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, length = 50)
    public String apellidoMaterno;

    @Column(name = "celular", nullable = false, length = 9)
    public String celular;

    @Column(name = "dni", nullable = false, length = 8, unique = true)
    public String dni;

    @Column(name = "direccion")
    public String direccion;

    @Column(name = "email", length = 100)
    public String email;

    @Column(name = "estado")
    private Boolean estado;
//
    @OneToMany( fetch = FetchType.LAZY,  mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> listaConsulta;

}
