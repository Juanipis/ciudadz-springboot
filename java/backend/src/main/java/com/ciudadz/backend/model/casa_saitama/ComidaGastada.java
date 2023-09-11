package com.ciudadz.backend.model.casa_saitama;

import java.util.Date;

import com.ciudadz.backend.model.characters.Personaje;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comida_gastada")
public class ComidaGastada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "casa_saitama_id")
    private CasaSaitama casaSaitama;

    @ManyToOne
    @JoinColumn(name = "personaje_id")
    private Personaje personaje;

    @Column
    private Date fecha;

    @ManyToOne
    private Comida comida;

}
