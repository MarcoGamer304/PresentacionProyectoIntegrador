/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import java.util.Optional;
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
    CarreraRepository carreraRepository;

    public ArrayList<CarreraModel> obtenerCarrera() {
        return (ArrayList<CarreraModel>) carreraRepository.findAll();
    }

    public CarreraModel obtenerCarreraId(Long id) {
        Optional<CarreraModel> carrera = carreraRepository.findById(id);
        return carrera.orElse(null);
    }

    public CarreraModel guardarCarrera(CarreraModel carrera) {
        return carreraRepository.save(carrera);
    }

    @Transactional
    public void eliminarCarrera(Long id) {
        if (carreraRepository.existsById(id)) {
            carreraRepository.deleteById(id);
        } else {
            System.out.println("fallo");
        }
    }
}

