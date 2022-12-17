package com.connect.tea.connecttea.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.connect.tea.connecttea.dto.UsuarioDTO;
import com.connect.tea.connecttea.model.Usuario;

@Service
public interface UsuarioService {

    /**
     * Registro de un nuevo usuario
     * @param usuarioDto Usuario a registrar
     * @return ResponseEntity<Usuario>
     */
    ResponseEntity<Usuario> registrarUsuario(UsuarioDTO usuarioDto);
    
}
