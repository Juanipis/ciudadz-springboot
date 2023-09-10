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

import com.ciudadz.backend.model.characters.Heroe;
import com.ciudadz.backend.services.characters.heroe.IHeroeService;

@RestController
@RequestMapping("/api/heroe")
public class HeroeController {
    @Autowired
    private IHeroeService heroeService;

    @GetMapping("/all")
    public String findAll() {
        return heroeService.findAll().toString();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(Long id) {
        Heroe heroe = heroeService.findById(id);
        Map<String, String> response = new HashMap<>();
        if (heroe == null) {
            response.put("mensaje", "El heroe con ID ".concat(id.toString()).concat(" no existe"));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(heroe);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(Heroe heroe) {
        Heroe heroeUpdated = heroeService.save(heroe);
        Map<String, String> response = new HashMap<>();
        if (heroeUpdated == null) {
            response.put("mensaje", "No se pudo actualizar el heroe");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Heroe actualizado con exito");
        response.put("heroe", heroeUpdated.toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(Heroe heroe) {
        Heroe heroeNew = heroeService.save(heroe);
        Map<String, String> response = new HashMap<>();
        if (heroeNew == null) {
            response.put("mensaje", "No se pudo crear el heroe");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Heroe creado con exito");
        response.put("heroe", heroeNew.toString());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        if (heroeService.findById(id) == null) {
            response.put("mensaje", "El heroe con ID ".concat(id.toString()).concat(" no existe"));
            return ResponseEntity.notFound().build();
        }
        heroeService.deleteById(id);
        response.put("mensaje", "Heroe eliminado con exito");
        return ResponseEntity.ok(response);
    }
}
