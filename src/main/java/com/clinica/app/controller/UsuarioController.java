package com.clinica.app.controller;

import com.clinica.app.entity.Usuario;
import com.clinica.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @GetMapping("/buscar/{id}")
    public Usuario buscarUno(@PathVariable(name = "id") Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Usuario usuario) {
        usuarioService.guardarOrUpdate(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable(name = "id") Integer id){
        usuarioService.eliminar(id);
    }
}
