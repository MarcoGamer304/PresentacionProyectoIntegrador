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
import ucr.ac.cr.api.models.EtiquetaModel;
import ucr.ac.cr.api.services.EtiquetaService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

    @Autowired
    EtiquetaService etiquetaService;

    @GetMapping("/allEtiqueta")
    public ArrayList<EtiquetaModel> obtenerEtiqueta() {
        return etiquetaService.obtenerEtiqueta();
    }

    @PostMapping()
    public EtiquetaModel guardarEtiqueta(@RequestBody EtiquetaModel etiqueta) {
        return this.etiquetaService.guardarEtiqueta(etiqueta);
    }

    @PatchMapping()
    public EtiquetaModel modificarEtiqueta(@RequestBody EtiquetaModel etiqueta) {
        return this.etiquetaService.guardarEtiqueta(etiqueta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEtiqueta(@PathVariable Long id) {
        etiquetaService.eliminarEtiqueta(id);
        return ResponseEntity.noContent().build();
    }
}
