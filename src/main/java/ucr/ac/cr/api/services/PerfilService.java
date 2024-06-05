/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.PerfilModel;
import ucr.ac.cr.api.repositories.PerfilRepository;

/**
 *
 * @author Marco
 */
@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    public ArrayList<PerfilModel> obtenerPerfil() {
        return (ArrayList<PerfilModel>) perfilRepository.findAll();
    }

    public PerfilModel guardarPerfil(PerfilModel perfil) {
        return perfilRepository.save(perfil);
    }

    @Transactional
    public void eliminarPerfil(Long id) {
        if (perfilRepository.existsById(id)) {
            perfilRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }
}
