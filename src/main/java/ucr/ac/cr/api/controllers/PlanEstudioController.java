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
import ucr.ac.cr.api.models.PlanEstudioModel;
import ucr.ac.cr.api.services.PlanEstudioService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/planEstudio")
public class PlanEstudioController {

    @Autowired
    PlanEstudioService planEstudioService;

    @GetMapping("/allPlanEstudio")
    public ArrayList<PlanEstudioModel> obtenerPlanEstudio() {
        return planEstudioService.obtenerPlanEstudio();
    }

    @PostMapping()
    public PlanEstudioModel guardarPlanEstudio(@RequestBody PlanEstudioModel planEstudio) {
        return this.planEstudioService.guardarPlanEstudio(planEstudio);
    }

    @PatchMapping()
    public PlanEstudioModel modificarPlanEstudio(@RequestBody PlanEstudioModel planEstudio) {
        return this.planEstudioService.guardarPlanEstudio(planEstudio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPlanEstudio(@PathVariable Long id) {
        planEstudioService.eliminarPlanEstudio(id);
        return ResponseEntity.noContent().build();
    }
}
