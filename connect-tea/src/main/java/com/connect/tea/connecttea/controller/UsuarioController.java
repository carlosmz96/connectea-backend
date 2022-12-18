package com.connect.tea.connecttea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connect.tea.connecttea.dto.UsuarioDTO;
import com.connect.tea.connecttea.model.Usuario;
import com.connect.tea.connecttea.service.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/registro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registroUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        final ResponseEntity<Usuario> resp = usuarioService.registrarUsuario(usuarioDTO);
        
        if (resp.getStatusCode().value() == 201) {
            return "Usuario registrado correctamente.";
        } else {
            return "Error al registrar al usuario.";
        }
    }

    @GetMapping(value = "/listado", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UsuarioDTO> listadoUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PutMapping(value = "/modificar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO modificarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        final ResponseEntity<UsuarioDTO> resp = usuarioService.modificarUsuario(usuarioDTO);
        
        if (resp.getStatusCode().value() == 200) {
            return resp.getBody();
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String eliminarUsuario(@PathVariable Long id) {
        final ResponseEntity<String> resp = usuarioService.eliminarUsuario(id);

        if (resp.getStatusCode().value() == 200) {
            return resp.getBody();
        } else {
            return "Error al eliminar el usuario";
        }
    }

}
