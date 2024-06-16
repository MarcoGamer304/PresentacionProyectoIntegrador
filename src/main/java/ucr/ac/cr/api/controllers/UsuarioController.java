/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.cr.api.models.UsuarioModel;
import ucr.ac.cr.api.services.UsuarioService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioId(@PathVariable Long id) {
        UsuarioModel usuario = usuarioService.obtenerUsuarioId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allUsuario")
    public ArrayList<UsuarioModel> obtenerUsuario() {
        return usuarioService.obtenerUsuario();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @PatchMapping()
    public UsuarioModel modificarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
