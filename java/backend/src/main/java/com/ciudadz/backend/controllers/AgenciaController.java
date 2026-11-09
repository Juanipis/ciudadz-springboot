package com.ciudadz.backend.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciudadz.backend.model.Agencia;
import com.ciudadz.backend.services.IAgenciaService;

@RestController
@RequestMapping("/api/agencia")
public class AgenciaController {
    @Autowired
    private IAgenciaService agenciaService;

    @GetMapping("/all")
    public String findAll() {
        return agenciaService.findAll().toString();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(Long id) {
        Agencia agencia = agenciaService.findById(id);
        Map<String, String> response = new HashMap<>();
        if (agencia == null) {
            response.put("mensaje", "La agencia con ID ".concat(id.toString()).concat(" no existe"));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agencia);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(Agencia agencia) {
        Agencia agenciaUpdated = agenciaService.save(agencia);
        Map<String, String> response = new HashMap<>();
        if (agenciaUpdated == null) {
            response.put("mensaje", "No se pudo actualizar la agencia");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Agencia actualizada con exito");
        response.put("agencia", agenciaUpdated.toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(Agencia agencia) {
        Agencia agenciaNew = agenciaService.save(agencia);
        Map<String, String> response = new HashMap<>();
        if (agenciaNew == null) {
            response.put("mensaje", "No se pudo crear la agencia");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Agencia creada con exito");
        response.put("agencia", agenciaNew.toString());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            agenciaService.deleteById(id);
        } catch (Exception e) {
            response.put("mensaje", "No se pudo eliminar la agencia");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Agencia eliminada con exito");
        return ResponseEntity.ok(response);
    }
}
