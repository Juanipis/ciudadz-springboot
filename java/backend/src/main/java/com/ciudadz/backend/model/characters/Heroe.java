package com.ciudadz.backend.model.characters;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "heroe")
public class Heroe extends Personaje {
    @Column
    private char rango;

    public char getRango() {
        return rango;
    }

    public void setRango(char rango) {
        this.rango = rango;
    }

    @Column
    private String habilidad;

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    @Column
    private String residencia;

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    @Column
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
