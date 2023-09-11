package com.ciudadz.backend.services.casa_saitama.casa;

import java.util.List;

import com.ciudadz.backend.model.casa_saitama.CasaSaitama;

public interface ICasaService {
    public List<CasaSaitama> findAll();

    public CasaSaitama findById(Long id);

    public void deleteById(Long id);

    public CasaSaitama save(CasaSaitama casa);
}
