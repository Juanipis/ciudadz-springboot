package com.ciudadz.backend.services;

import java.util.List;

import com.ciudadz.backend.model.Agencia;

public interface IAgenciaService {
    public List<Agencia> findAll();

    public Agencia findById(Long id);

    public void deleteById(Long id);

    public Agencia save(Agencia agencia);
}
