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

import com.ciudadz.backend.model.characters.Fan;
import com.ciudadz.backend.services.characters.fan.IFanService;

@RestController
@RequestMapping("/api/fan")
public class FanController {
    @Autowired
    private IFanService fanService;

    @GetMapping("/all")
    public String findAll() {
        return fanService.findAll().toString();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(Long id) {
        Fan fan = fanService.findById(id);
        Map<String, String> response = new HashMap<>();
        if (fan == null) {
            response.put("mensaje", "El fan con ID ".concat(id.toString()).concat(" no existe"));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fan);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(Fan fan) {
        Fan fanUpdated = fanService.save(fan);
        Map<String, String> response = new HashMap<>();
        if (fanUpdated == null) {
            response.put("mensaje", "No se pudo actualizar el fan");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Fan actualizado con exito");
        response.put("fan", fanUpdated.toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(Fan fan) {
        Fan fanNew = fanService.save(fan);
        Map<String, String> response = new HashMap<>();
        if (fanNew == null) {
            response.put("mensaje", "No se pudo crear el fan");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Fan creado con exito");
        response.put("fan", fanNew.toString());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        Map<String, String> response = new HashMap<>();
        if (fanService.findById(id) == null) {
            response.put("mensaje", "El fan con ID ".concat(id.toString()).concat(" no existe"));
            return ResponseEntity.notFound().build();
        }
        fanService.deleteById(id);
        response.put("mensaje", "Fan eliminado con exito");
        return ResponseEntity.ok(response);
    }
}
