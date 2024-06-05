/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.CicloModel;
import ucr.ac.cr.api.repositories.CicloRepository;

/**
 *
 * @author Marco
 */
@Service
public class CicloService {

    @Autowired
    CicloRepository cicloRepository;

    public ArrayList<CicloModel> obtenerCiclo() {
        return (ArrayList<CicloModel>) cicloRepository.findAll();
    }

    public CicloModel guardarCiclo(CicloModel ciclo) {
        return cicloRepository.save(ciclo);
    }

    @Transactional
    public void eliminarCiclo(Long id) {
        if (cicloRepository.existsById(id)) {
            cicloRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }
}
