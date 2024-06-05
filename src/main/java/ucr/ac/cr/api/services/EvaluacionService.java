/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.EvaluacionModel;
import ucr.ac.cr.api.repositories.EvaluacionRepository;

/**
 *
 * @author Marco
 */
@Service
public class EvaluacionService {

    @Autowired
    EvaluacionRepository evaluacionRepository;

    public ArrayList<EvaluacionModel> obtenerEvaluacion() {
        return (ArrayList<EvaluacionModel>) evaluacionRepository.findAll();
    }

    public EvaluacionModel guardarEvaluacion(EvaluacionModel evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @Transactional
    public void eliminarEvaluacion(Long id) {
        if (evaluacionRepository.existsById(id)) {
            evaluacionRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }
}
