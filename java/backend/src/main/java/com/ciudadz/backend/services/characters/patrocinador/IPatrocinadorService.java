package com.ciudadz.backend.services.characters.patrocinador;

import java.util.List;

import com.ciudadz.backend.model.characters.Patrocinador;

public interface IPatrocinadorService {
    public List<Patrocinador> findAll();

    public Patrocinador findById(Long id);

    public void deleteById(Long id);

    public Patrocinador save(Patrocinador patrocinador);
}
