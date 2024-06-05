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
import ucr.ac.cr.api.models.GrupoModel;
import ucr.ac.cr.api.services.GrupoService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @GetMapping("/allGrupo")
    public ArrayList<GrupoModel> obtenerGrupo() {
        return grupoService.obtenerGrupo();
    }

    @PostMapping()
    public GrupoModel guardarGrupo(@RequestBody GrupoModel grupo) {
        return this.grupoService.guardarGrupo(grupo);
    }

    @PatchMapping()
    public GrupoModel modificarGrupo(@RequestBody GrupoModel grupo) {
        return this.grupoService.guardarGrupo(grupo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGrupo(@PathVariable Long id) {
        grupoService.eliminarGrupo(id);
        return ResponseEntity.noContent().build();
    }
}
