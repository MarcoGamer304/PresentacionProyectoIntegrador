/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.CategoriaModel;
import ucr.ac.cr.api.repositories.CategoriaRepository;

/**
 *
 * @author Marco
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public ArrayList<CategoriaModel> obtenerCategoria() {
        return (ArrayList<CategoriaModel>) categoriaRepository.findAll();
    }

    public CategoriaModel guardarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public void eliminarCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }
}
