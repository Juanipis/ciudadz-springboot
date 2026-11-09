package com.ciudadz.backend.services.characters.heroe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciudadz.backend.dao.characters.IHeroeDAO;
import com.ciudadz.backend.model.characters.Heroe;

@Service
public class HeroeService implements IHeroeService {
    @Autowired
    private IHeroeDAO heroeDAO;

    @Override
    public List<Heroe> findAll() {
        return heroeDAO.findAll();
    }

    @Override
    public Heroe findById(Long id) {
        return heroeDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        heroeDAO.deleteById(id);
    }

    @Override
    public Heroe save(Heroe heroe) {
        return heroeDAO.save(heroe);
    }

}
