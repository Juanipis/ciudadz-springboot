package com.ciudadz.backend.dao.characters;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciudadz.backend.model.characters.Mounstro;

public interface IMounstroDAO extends JpaRepository<Mounstro, Long> {

}
