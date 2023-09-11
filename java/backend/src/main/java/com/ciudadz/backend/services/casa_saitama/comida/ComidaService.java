package com.ciudadz.backend.services.casa_saitama.comida;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciudadz.backend.dao.casa_saitama.IComidaDAO;
import com.ciudadz.backend.model.casa_saitama.Comida;

@Service
public class ComidaService implements IComidaService {
    @Autowired
    private IComidaDAO comidaDAO;

    @Override
    public List<Comida> findAll() {
        return comidaDAO.findAll();
    }

    @Override
    public Comida findById(Long id) {
        return comidaDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        comidaDAO.deleteById(id);
    }

    @Override
    public Comida save(Comida comida) {
        return comidaDAO.save(comida);
    }

}
