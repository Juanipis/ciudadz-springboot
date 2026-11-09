package com.ciudadz.backend.model.characters;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mounstro")
public class Mounstro extends Personaje {
    @Column
    private char nivelAmenaza;

    public char getNivelAmenaza() {
        return nivelAmenaza;
    }

    public void setNivelAmenaza(char nivelAmenaza) {
        this.nivelAmenaza = nivelAmenaza;
    }

}
