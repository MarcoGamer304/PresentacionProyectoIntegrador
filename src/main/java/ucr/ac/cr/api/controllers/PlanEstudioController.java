/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.controllers;

import java.util.ArrayList;
import java.util.List;
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
import ucr.ac.cr.api.repositories.PlanEstudioRepository;
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

    @Autowired
    PlanEstudioRepository planEstudioRepository;

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

    //Añadir un curso por id
    @PostMapping("/{planId}/cursos/{cursoId}")
    public ResponseEntity<PlanEstudioModel> agregarCursoAPlan(@PathVariable Long planId, @PathVariable Long cursoId) {
        PlanEstudioModel updatedPlan = planEstudioService.agregarCursoAPlan(planId, cursoId);
        return ResponseEntity.ok(updatedPlan);
    }

    //Añadir varios por el cuerpo JSON as "cursoIds"
    @PostMapping("/{planId}/cursos")
    public ResponseEntity<PlanEstudioModel> agregarCursosAPlan(@PathVariable Long planId, @RequestBody List<Long> cursoIds) {
        for (Long cursoId : cursoIds) {
            planEstudioService.agregarCursoAPlan(planId, cursoId);
        }
        PlanEstudioModel planActualizado = planEstudioRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan de estudio no encontrado"));
        return ResponseEntity.ok(planActualizado);
    }
    
    @PatchMapping("/{planId}/cursos")
    public ResponseEntity<PlanEstudioModel> modificarCursosAPlan(@PathVariable Long planId, @RequestBody List<Long> cursoIds) {
        for (Long cursoId : cursoIds) {
            planEstudioService.agregarCursoAPlan(planId, cursoId);
        }
        PlanEstudioModel planActualizado = planEstudioRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan de estudio no encontrado"));
        return ResponseEntity.ok(planActualizado);
    }

    @DeleteMapping("/{planId}/cursos/{cursoId}")
    public ResponseEntity<PlanEstudioModel> eliminarCursoDePlan(@PathVariable Long planId, @PathVariable Long cursoId) {
        PlanEstudioModel updatedPlan = planEstudioService.eliminarCursoDePlan(planId, cursoId);
        return ResponseEntity.ok(updatedPlan);
    }
}
