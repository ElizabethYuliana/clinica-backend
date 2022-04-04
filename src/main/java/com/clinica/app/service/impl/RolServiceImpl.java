package com.clinica.app.service.impl;

import com.clinica.app.entity.Rol;
import com.clinica.app.repository.RolRepository;
import com.clinica.app.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public void guardarOrUpdate(Rol t) {
        rolRepository.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Rol r = rolRepository.findById(id).get();
        rolRepository.delete(r);
    }

    @Override
    public Rol findById(Integer id) {
        return rolRepository.findById(id).get();
    }
}
