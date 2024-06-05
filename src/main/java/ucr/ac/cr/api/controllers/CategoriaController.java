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
import ucr.ac.cr.api.models.CategoriaModel;
import ucr.ac.cr.api.services.CategoriaService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/allCategoria")
    public ArrayList<CategoriaModel> obtenerCategoria() {
        return categoriaService.obtenerCategoria();
    }

    @PostMapping()
    public CategoriaModel guardarCategoria(@RequestBody CategoriaModel etiqueta) {
        return this.categoriaService.guardarCategoria(etiqueta);
    }

    @PatchMapping()
    public CategoriaModel modificarCategoria(@RequestBody CategoriaModel etiqueta) {
        return this.categoriaService.guardarCategoria(etiqueta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
