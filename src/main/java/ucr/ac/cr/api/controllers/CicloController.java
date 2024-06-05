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
import ucr.ac.cr.api.models.CicloModel;
import ucr.ac.cr.api.services.CicloService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/ciclo")
public class CicloController {

    @Autowired
    CicloService cicloService;

    @GetMapping("/allCiclo")
    public ArrayList<CicloModel> obtenerCiclo() {
        return cicloService.obtenerCiclo();
    }

    @PostMapping()
    public CicloModel guardarCiclo(@RequestBody CicloModel ciclo) {
        return this.cicloService.guardarCiclo(ciclo);
    }

    @PatchMapping()
    public CicloModel modificarCiclo(@RequestBody CicloModel ciclo) {
        return this.cicloService.guardarCiclo(ciclo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCiclo(@PathVariable Long id) {
        cicloService.eliminarCiclo(id);
        return ResponseEntity.noContent().build();
    }
}
