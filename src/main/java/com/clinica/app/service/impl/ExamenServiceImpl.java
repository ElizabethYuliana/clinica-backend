package com.clinica.app.service.impl;

import com.clinica.app.entity.Examen;
import com.clinica.app.repository.ExamenRepository;
import com.clinica.app.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    ExamenRepository examenRepository;


    @Override
    public List<Examen> listar() {
        return examenRepository.findAll();
    }

    @Override
    public void guardarOrUpdate(Examen t) {
        examenRepository.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Examen e = examenRepository.findById(id).get();
        examenRepository.delete(e);
    }

    @Override
    public Examen findById(Integer id) {
        return examenRepository.findById(id).get();
    }
}
