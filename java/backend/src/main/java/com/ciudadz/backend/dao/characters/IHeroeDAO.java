package com.ciudadz.backend.dao.characters;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciudadz.backend.model.characters.Heroe;

public interface IHeroeDAO extends JpaRepository<Heroe, Long> {

}
