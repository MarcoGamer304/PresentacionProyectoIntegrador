/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.EtiquetaModel;
import ucr.ac.cr.api.repositories.EtiquetaRepository;

/**
 *
 * @author Marco
 */
@Service
public class EtiquetaService {

    @Autowired
    EtiquetaRepository etiquetaRepository;

    public ArrayList<EtiquetaModel> obtenerEtiqueta() {
        return (ArrayList<EtiquetaModel>) etiquetaRepository.findAll();
    }

    public EtiquetaModel guardarEtiqueta(EtiquetaModel etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    @Transactional
    public void eliminarEtiqueta(Long id) {
        if (etiquetaRepository.existsById(id)) {
            etiquetaRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }
}
