/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.CursoModel;
import ucr.ac.cr.api.models.PlanEstudioModel;
import ucr.ac.cr.api.repositories.CursoRepository;
import ucr.ac.cr.api.repositories.PlanEstudioRepository;

/**
 *
 * @author Marco
 */
@Service
public class PlanEstudioService {

    @Autowired
    PlanEstudioRepository planEstudioRepository;

    @Autowired
    CursoRepository cursoRepository;

    public ArrayList<PlanEstudioModel> obtenerPlanEstudio() {
        return (ArrayList<PlanEstudioModel>) planEstudioRepository.findAll();
    }

    public PlanEstudioModel guardarPlanEstudio(PlanEstudioModel planEstudio) {
        return planEstudioRepository.save(planEstudio);
    }

    @Transactional
    public void eliminarPlanEstudio(Long id) {
        if (planEstudioRepository.existsById(id)) {
            planEstudioRepository.deleteById(id);
        } else {
            System.out.println("fallo");
        }
    }

    @Transactional
    public PlanEstudioModel agregarCursoAPlan(Long planId, Long cursoId) {
        PlanEstudioModel plan = planEstudioRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
        CursoModel curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        plan.getCursos().add(curso);
        return planEstudioRepository.save(plan);
    }

    @Transactional
    public PlanEstudioModel eliminarCursoDePlan(Long planId, Long cursoId) {
        PlanEstudioModel plan = planEstudioRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
        CursoModel curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        plan.getCursos().remove(curso);
        return planEstudioRepository.save(plan);
    }
}
