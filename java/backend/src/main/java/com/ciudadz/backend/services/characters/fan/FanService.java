package com.ciudadz.backend.services.characters.fan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciudadz.backend.dao.characters.IFanDAO;
import com.ciudadz.backend.model.characters.Fan;

@Service
public class FanService implements IFanService {
    @Autowired
    private IFanDAO fanDAO;

    @Override
    public List<Fan> findAll() {
        return fanDAO.findAll();
    }

    @Override
    public Fan findById(Long id) {
        return fanDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        fanDAO.deleteById(id);
    }

    @Override
    public Fan save(Fan fan) {
        return fanDAO.save(fan);
    }

}
