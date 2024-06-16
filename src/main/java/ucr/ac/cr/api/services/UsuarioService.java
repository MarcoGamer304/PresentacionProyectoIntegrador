/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.ac.cr.api.models.PerfilModel;
import ucr.ac.cr.api.models.UsuarioModel;
import ucr.ac.cr.api.repositories.PerfilRepository;
import ucr.ac.cr.api.repositories.UsuarioRepository;

/**
 *
 * @author Marco
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;

    public ArrayList<UsuarioModel> obtenerUsuario() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel obtenerUsuarioId(Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null); 
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        if (usuario.getListaPerfil() != null) {
            for (PerfilModel perfil : usuario.getListaPerfil()) {
                perfil.setUsuario(usuario);
            }
        }
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {

            System.out.println("fallo");
        }
    }
}
