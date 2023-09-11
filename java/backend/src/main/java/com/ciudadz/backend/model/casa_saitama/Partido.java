package com.ciudadz.backend.model.casa_saitama;

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
@Table(name = "partido")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "casa_saitama_id")
    private CasaSaitama casaSaitama;

    @ManyToOne
    @JoinColumn(name = "videojuego_id")
    private Videojuego videojuego;

    @ManyToOne
    @JoinColumn(name = "jugador_1_id")
    private Personaje jugador1;

    @ManyToOne
    @JoinColumn(name = "jugador_2_id")
    private Personaje jugador2;

    @Column
    int ganador;
}
