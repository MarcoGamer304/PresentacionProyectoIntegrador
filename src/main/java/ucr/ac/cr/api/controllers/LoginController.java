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
import ucr.ac.cr.api.models.LoginModel;
import ucr.ac.cr.api.services.LoginService;

/**
 *
 * @author Marco
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/allUsers")
    public ArrayList<LoginModel> obtenerUsuarios() {
        return loginService.obtenerUsuarios();
    }

    @PostMapping()
    public LoginModel guardarUsuario(@RequestBody LoginModel model) {
        return this.loginService.guardarUsuario(model);
    }

    @PatchMapping()
    public LoginModel modificarUsuario(@RequestBody LoginModel model) {
        return this.loginService.guardarUsuario(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecurso(@PathVariable Long id) {
        loginService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
