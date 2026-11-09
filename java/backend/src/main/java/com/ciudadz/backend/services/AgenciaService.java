package com.ciudadz.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciudadz.backend.dao.IAgenciaDAO;
import com.ciudadz.backend.model.Agencia;

@Service
public class AgenciaService implements IAgenciaService {
    @Autowired
    private IAgenciaDAO agenciaDAO;

    @Override
    public List<Agencia> findAll() {
        return agenciaDAO.findAll();
    }

    @Override
    public Agencia findById(Long id) {
        return agenciaDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        agenciaDAO.deleteById(id);
    }

    @Override
    public Agencia save(Agencia agencia) {
        return agenciaDAO.save(agencia);
    }

}
