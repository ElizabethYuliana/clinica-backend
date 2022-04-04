package com.clinica.app.service.impl;

import com.clinica.app.repository.BaseRepository;
import com.clinica.app.service.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl{/*<T> implements BaseEntityService<T> {

    @Autowired
    BaseRepository<T> baseRepository;

    @Override
    public List<T> listar() {
        return baseRepository.findAll();
    }

    @Override
    public void guardarOrUpdate(T t) {
        baseRepository.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        T t = baseRepository.findById(id).get();
        baseRepository.delete(t);
    }

    @Override
    public T findById(Integer id) {
        return baseRepository.findById(id).get();
    }**/
}
