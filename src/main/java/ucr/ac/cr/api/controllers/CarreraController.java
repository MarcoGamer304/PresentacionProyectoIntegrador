/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.cr.api.models.CarreraModel;
import ucr.ac.cr.api.services.CarreraService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    CarreraService carreraService;

    @GetMapping("/allCarrera")
    public ArrayList<CarreraModel> obtenerCarrera() {
        return carreraService.obtenerCarrera();
    }

    @PostMapping()
    public CarreraModel guardarCarrera(@RequestBody CarreraModel carrera) {
        return this.carreraService.guardarCarrera(carrera);
    }

    @PatchMapping()
    public CarreraModel modificarCarrera(@RequestBody CarreraModel carrera) {
        return this.carreraService.guardarCarrera(carrera);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrera(@PathVariable Long id) {
        carreraService.eliminarCarrera(id);
        return ResponseEntity.noContent().build();
    }
}
