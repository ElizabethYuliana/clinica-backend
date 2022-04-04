package com.clinica.app.service.impl;

import com.clinica.app.entity.Medico;
import com.clinica.app.repository.MedicoRepository;
import com.clinica.app.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    @Override
    public void guardarOrUpdate(Medico t) {
        medicoRepository.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Medico m = medicoRepository.findById(id).get();
        medicoRepository.delete(m);
    }

    @Override
    public Medico findById(Integer id) {
        return medicoRepository.findById(id).get();
    }
}
