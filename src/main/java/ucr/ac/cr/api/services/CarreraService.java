/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.CarreraModel;
import ucr.ac.cr.api.repositories.CarreraRepository;

/**
 *
 * @author Marco
 */
@Service
public class CarreraService {

    @Autowired
    CarreraRepository CarreraRepository;

    public ArrayList<CarreraModel> obtenerCarrera() {
        return (ArrayList<CarreraModel>) CarreraRepository.findAll();
    }

    public CarreraModel guardarCarrera(CarreraModel carrera) {
        return CarreraRepository.save(carrera);
    }

    @Transactional
    public void eliminarCarrera(Long id) {
        if (CarreraRepository.existsById(id)) {
            CarreraRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }
}
