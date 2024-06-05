/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.ActividadModel;
import ucr.ac.cr.api.repositories.ActividadRepository;

/**
 *
 * @author Marco
 */
@Service
public class ActividadService {

    @Autowired
    ActividadRepository actividadRepository;

    public ArrayList<ActividadModel> obtenerActividad() {
        return (ArrayList<ActividadModel>) actividadRepository.findAll();
    }

    public ActividadModel guardarActividad(ActividadModel actividad) {
        return actividadRepository.save(actividad);
    }

    @Transactional
    public void eliminarActividad(Long id) {
        if (actividadRepository.existsById(id)) {
            actividadRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }
}
