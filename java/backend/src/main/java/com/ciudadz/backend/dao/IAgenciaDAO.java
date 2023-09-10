package com.ciudadz.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciudadz.backend.model.Agencia;

public interface IAgenciaDAO extends JpaRepository<Agencia, Long> {

}
