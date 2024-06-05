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
import ucr.ac.cr.api.models.CursoModel;
import ucr.ac.cr.api.services.CursoService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("/allCurso")
    public ArrayList<CursoModel> obtenerCurso() {
        return cursoService.obtenerCurso();
    }

    @PostMapping()
    public CursoModel guardarCurso(@RequestBody CursoModel curso) {
        return this.cursoService.guardarCurso(curso);
    }

    @PatchMapping()
    public CursoModel modificarCurso(@RequestBody CursoModel curso) {
        return this.cursoService.guardarCurso(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
