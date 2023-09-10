package com.ciudadz.backend.services.characters.heroe;

import java.util.List;

import com.ciudadz.backend.model.characters.Heroe;

public interface IHeroeService {
    public List<Heroe> findAll();

    public Heroe findById(Long id);

    public void deleteById(Long id);

    public Heroe save(Heroe heroe);
}
