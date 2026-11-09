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

import com.ciudadz.backend.model.characters.Patrocinador;
import com.ciudadz.backend.services.characters.patrocinador.IPatrocinadorService;

@RestController
@RequestMapping("/api/patrocinador")
public class PatrocinadorController {
    @Autowired
    private IPatrocinadorService patrocinadorService;

    @GetMapping("/all")
    public String findAll() {
        return patrocinadorService.findAll().toString();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(Long id) {
        Patrocinador patrocinador = patrocinadorService.findById(id);
        Map<String, String> response = new HashMap<>();
        if (patrocinador == null) {
            response.put("mensaje", "El patrocinador con ID ".concat(id.toString()).concat(" no existe"));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patrocinador);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(Patrocinador patrocinador) {
        Patrocinador patrocinadorUpdated = patrocinadorService.save(patrocinador);
        Map<String, String> response = new HashMap<>();
        if (patrocinadorUpdated == null) {
            response.put("mensaje", "No se pudo actualizar el patrocinador");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Patrocinador actualizado con exito");
        response.put("patrocinador", patrocinadorUpdated.toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(Patrocinador patrocinador) {
        Patrocinador patrocinadorNew = patrocinadorService.save(patrocinador);
        Map<String, String> response = new HashMap<>();
        if (patrocinadorNew == null) {
            response.put("mensaje", "No se pudo crear el patrocinador");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Patrocinador creado con exito");
        response.put("patrocinador", patrocinadorNew.toString());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        if (patrocinadorService.findById(id) == null) {
            response.put("mensaje", "El patrocinador con ID ".concat(id.toString()).concat(" no existe"));
            return ResponseEntity.notFound().build();
        }
        patrocinadorService.deleteById(id);
        response.put("mensaje", "Patrocinador eliminado con exito");
        return ResponseEntity.ok(response);
    }
}
