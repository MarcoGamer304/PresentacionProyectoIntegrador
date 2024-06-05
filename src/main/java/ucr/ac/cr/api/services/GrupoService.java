/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.GrupoModel;
import ucr.ac.cr.api.repositories.GrupoRepository;

/**
 *
 * @author Marco
 */
@Service
public class GrupoService {

    @Autowired
    GrupoRepository grupoRepository;

    public ArrayList<GrupoModel> obtenerGrupo() {
        return (ArrayList<GrupoModel>) grupoRepository.findAll();
    }

    public GrupoModel guardarGrupo(GrupoModel usuario) {
        return grupoRepository.save(usuario);
    }

    @Transactional
    public void eliminarGrupo(Long id) {
        if (grupoRepository.existsById(id)) {
            grupoRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }

}
