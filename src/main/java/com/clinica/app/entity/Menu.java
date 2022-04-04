package com.clinica.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer idMenu;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "url")
    private String url;

    @Column(name = "icono")
    private String icono;

    @ManyToMany
    @JoinTable(name = "menu_rol",
                joinColumns = @JoinColumn(name = "id_menu"),
                inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private List<Rol> listaRol;


}
