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
import ucr.ac.cr.api.models.PerfilModel;
import ucr.ac.cr.api.services.PerfilService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    PerfilService perfilService;

    @GetMapping("/allPerfil")
    public ArrayList<PerfilModel> obtenerPerfil() {
        return perfilService.obtenerPerfil();
    }

    @PostMapping()
    public PerfilModel guardarPerfil(@RequestBody PerfilModel perfil) {
        return this.perfilService.guardarPerfil(perfil);
    }

    @PatchMapping()
    public PerfilModel modificarPerfil(@RequestBody PerfilModel perfil) {
        return this.perfilService.guardarPerfil(perfil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable Long id) {
        perfilService.eliminarPerfil(id);
        return ResponseEntity.noContent().build();
    }
}
