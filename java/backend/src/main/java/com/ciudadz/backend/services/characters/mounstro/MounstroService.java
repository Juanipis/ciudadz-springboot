package com.ciudadz.backend.services.characters.mounstro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciudadz.backend.dao.characters.IMounstroDAO;
import com.ciudadz.backend.model.characters.Mounstro;

@Service
public class MounstroService implements IMounstroService {
    @Autowired
    private IMounstroDAO mounstroDAO;

    @Override
    public List<Mounstro> findAll() {
        return mounstroDAO.findAll();
    }

    @Override
    public Mounstro findById(Long id) {
        return mounstroDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        mounstroDAO.deleteById(id);
    }

    @Override
    public Mounstro save(Mounstro mounstro) {
        return mounstroDAO.save(mounstro);
    }

}
