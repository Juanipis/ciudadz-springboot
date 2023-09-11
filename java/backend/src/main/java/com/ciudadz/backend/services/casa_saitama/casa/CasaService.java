package com.ciudadz.backend.services.casa_saitama.casa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciudadz.backend.dao.casa_saitama.ICasaSaitamaDAO;
import com.ciudadz.backend.model.casa_saitama.CasaSaitama;

@Service
public class CasaService implements ICasaService {
    @Autowired
    private ICasaSaitamaDAO casaDAO;

    @Override
    public List<CasaSaitama> findAll() {
        return casaDAO.findAll();
    }

    @Override
    public CasaSaitama findById(Long id) {
        return casaDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        casaDAO.deleteById(id);
    }

    @Override
    public CasaSaitama save(CasaSaitama casa) {
        return casaDAO.save(casa);
    }

}
