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
import ucr.ac.cr.api.models.ActividadModel;
import ucr.ac.cr.api.services.ActividadService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    ActividadService actividadService;

    @GetMapping("/allActividad")
    public ArrayList<ActividadModel> obtenerUsuarios() {
        return actividadService.obtenerActividad();
    }

    @PostMapping()
    public ActividadModel guardarUsuario(@RequestBody ActividadModel actividad) {
        return this.actividadService.guardarActividad(actividad);
    }

    @PatchMapping()
    public ActividadModel modificarUsuario(@RequestBody ActividadModel actividad) {
        return this.actividadService.guardarActividad(actividad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecurso(@PathVariable Long id) {
        actividadService.eliminarActividad(id);
        return ResponseEntity.noContent().build();
    }
}
