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
import ucr.ac.cr.api.models.EvaluacionModel;
import ucr.ac.cr.api.services.EvaluacionService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/evaluacion")
public class EvaluacionController {

    @Autowired
    EvaluacionService EvaluacionService;

    @GetMapping("/allEvaluacion")
    public ArrayList<EvaluacionModel> obtenerEvaluacion() {
        return EvaluacionService.obtenerEvaluacion();
    }

    @PostMapping()
    public EvaluacionModel guardarEvaluacion(@RequestBody EvaluacionModel grupo) {
        return this.EvaluacionService.guardarEvaluacion(grupo);
    }

    @PatchMapping()
    public EvaluacionModel modificarEvaluacion(@RequestBody EvaluacionModel grupo) {
        return this.EvaluacionService.guardarEvaluacion(grupo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable Long id) {
        EvaluacionService.eliminarEvaluacion(id);
        return ResponseEntity.noContent().build();
    }
}
