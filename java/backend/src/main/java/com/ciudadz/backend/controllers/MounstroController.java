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

import com.ciudadz.backend.model.characters.Mounstro;
import com.ciudadz.backend.services.characters.mounstro.IMounstroService;

@RestController
@RequestMapping("/api/mounstro")
public class MounstroController {
    @Autowired
    private IMounstroService mounstroService;

    @GetMapping("/all")
    public String findAll() {
        return mounstroService.findAll().toString();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(Long id) {
        Mounstro mounstro = mounstroService.findById(id);
        Map<String, String> response = new HashMap<>();
        if (mounstro == null) {
            response.put("mensaje", "El mounstro con ID ".concat(id.toString()).concat(" no existe"));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mounstro);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(Mounstro mounstro) {
        Mounstro mounstroUpdated = mounstroService.save(mounstro);
        Map<String, String> response = new HashMap<>();
        if (mounstroUpdated == null) {
            response.put("mensaje", "No se pudo actualizar el mounstro");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Mounstro actualizado con exito");
        response.put("mounstro", mounstroUpdated.toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(Mounstro mounstro) {
        Mounstro mounstroNew = mounstroService.save(mounstro);
        Map<String, String> response = new HashMap<>();
        if (mounstroNew == null) {
            response.put("mensaje", "No se pudo crear el mounstro");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("mensaje", "Mounstro creado con exito");
        response.put("mounstro", mounstroNew.toString());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        mounstroService.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Mounstro eliminado con exito");
        return ResponseEntity.ok(response);
    }
}
