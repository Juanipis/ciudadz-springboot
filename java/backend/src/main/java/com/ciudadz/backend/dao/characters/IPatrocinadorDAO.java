package com.ciudadz.backend.dao.characters;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciudadz.backend.model.characters.Patrocinador;

public interface IPatrocinadorDAO extends JpaRepository<Patrocinador, Long> {

}
