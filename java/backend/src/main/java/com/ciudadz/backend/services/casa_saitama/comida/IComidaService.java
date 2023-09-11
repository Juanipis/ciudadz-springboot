package com.ciudadz.backend.services.casa_saitama.comida;

import java.util.List;

import com.ciudadz.backend.model.casa_saitama.Comida;

public interface IComidaService {
    public List<Comida> findAll();

    public Comida findById(Long id);

    public void deleteById(Long id);

    public Comida save(Comida comida);
}
