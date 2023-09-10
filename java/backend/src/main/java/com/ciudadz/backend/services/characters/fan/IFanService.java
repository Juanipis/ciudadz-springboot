package com.ciudadz.backend.services.characters.fan;

import java.util.List;

import com.ciudadz.backend.model.characters.Fan;

public interface IFanService {
    public List<Fan> findAll();

    public Fan findById(Long id);

    public void deleteById(Long id);

    public Fan save(Fan fan);
}
