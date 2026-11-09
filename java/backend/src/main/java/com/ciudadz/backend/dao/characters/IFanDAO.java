package com.ciudadz.backend.dao.characters;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciudadz.backend.model.characters.Fan;

public interface IFanDAO extends JpaRepository<Fan, Long> {

}
