package com.clinica.app.service.impl;

import com.clinica.app.entity.Especialidad;
import com.clinica.app.repository.EspecialidadRepository;
import com.clinica.app.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    EspecialidadRepository especialidadRepository;


    @Override
    public List<Especialidad> listar() {
        return especialidadRepository.findAll();
    }

    @Override
    public void guardarOrUpdate(Especialidad t) {
        especialidadRepository.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Especialidad especialidad = especialidadRepository.findById(id).get();
        especialidadRepository.delete(especialidad);
    }

    @Override
    public Especialidad findById(Integer id) {
        return especialidadRepository.findById(id).get();
    }
}
