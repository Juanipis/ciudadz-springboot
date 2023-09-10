package com.ciudadz.backend.services.characters.mounstro;

import java.util.List;

import com.ciudadz.backend.model.characters.Mounstro;

public interface IMounstroService {
    public List<Mounstro> findAll();

    public Mounstro findById(Long id);

    public void deleteById(Long id);

    public Mounstro save(Mounstro mounstro);
}
