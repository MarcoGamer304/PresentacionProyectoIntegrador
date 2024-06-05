/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.RecordatorioModel;
import ucr.ac.cr.api.repositories.RecordatorioRepository;

/**
 *
 * @author Marco
 */
@Service
public class RecordatorioService {

    @Autowired
    RecordatorioRepository recordatorioRepository;

    public ArrayList<RecordatorioModel> obtenerRecordatorio() {
        return (ArrayList<RecordatorioModel>) recordatorioRepository.findAll();
    }

    public RecordatorioModel guardarRecordatorio(RecordatorioModel recordatorio) {
        return recordatorioRepository.save(recordatorio);
    }

    @Transactional
    public void eliminarRecordatorio(Long id) {
        if (recordatorioRepository.existsById(id)) {
            recordatorioRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }
}
