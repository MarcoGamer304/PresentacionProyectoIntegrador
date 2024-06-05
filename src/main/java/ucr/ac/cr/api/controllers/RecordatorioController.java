/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.cr.api.models.RecordatorioModel;
import ucr.ac.cr.api.services.RecordatorioService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/recordatorio")
public class RecordatorioController {

    @Autowired
    RecordatorioService recordatorioService;

    @GetMapping("/allRecordatorio")
    public ArrayList<RecordatorioModel> obtenerPerfil() {
        return recordatorioService.obtenerRecordatorio();
    }

    @PostMapping()
    public RecordatorioModel guardarPerfil(@RequestBody RecordatorioModel recordatorio) {
        return this.recordatorioService.guardarRecordatorio(recordatorio);
    }

    @PatchMapping()
    public RecordatorioModel modificarPerfil(@RequestBody RecordatorioModel recordatorio) {
        return this.recordatorioService.guardarRecordatorio(recordatorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable Long id) {
        recordatorioService.eliminarRecordatorio(id);
        return ResponseEntity.noContent().build();
    }
}
