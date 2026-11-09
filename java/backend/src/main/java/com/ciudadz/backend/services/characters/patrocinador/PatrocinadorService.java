package com.ciudadz.backend.services.characters.patrocinador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciudadz.backend.dao.characters.IPatrocinadorDAO;
import com.ciudadz.backend.model.characters.Patrocinador;

@Service
public class PatrocinadorService implements IPatrocinadorService {
    @Autowired
    private IPatrocinadorDAO patrocinadorDAO;

    @Override
    public List<Patrocinador> findAll() {
        return patrocinadorDAO.findAll();
    }

    @Override
    public Patrocinador findById(Long id) {
        return patrocinadorDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        patrocinadorDAO.deleteById(id);
    }

    @Override
    public Patrocinador save(Patrocinador patrocinador) {
        return patrocinadorDAO.save(patrocinador);
    }

}
