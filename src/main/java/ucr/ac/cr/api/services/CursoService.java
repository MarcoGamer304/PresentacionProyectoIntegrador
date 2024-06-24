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
import ucr.ac.cr.api.repositories.CursoRepository;

/**
 *
 * @author Marco
 */
@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public ArrayList<CursoModel> obtenerCurso() {
        return (ArrayList<CursoModel>) cursoRepository.findAll();
    }

    public CursoModel guardarCurso(CursoModel curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public void eliminarCurso(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        } else {
            System.out.println("fallo");
        }
    }
}
