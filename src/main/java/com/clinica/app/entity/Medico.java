package com.clinica.app.entity;

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
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, length = 50)
    public String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, length = 50)
    public String apellidoMaterno;

    @Column(name = "cmp", nullable = false, unique = true)
    private String cmp;

    @Column(name = "dni", nullable = false, length = 8, unique = true)
    public String dni;

    @Column(name = "celular", nullable = false, length = 9)
    public String celular;

    @Column(name = "direccion")
    public String direccion;

    @Column(name = "email", length = 100)
    public String email;

    @Column(name = "foto_url")
    private String fotoUrl;

    @Column(name = "estado")
    private Boolean estado;

}
