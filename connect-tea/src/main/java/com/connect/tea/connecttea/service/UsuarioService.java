package com.connect.tea.connecttea.service;

import java.util.List;

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
     * @throws Exception
     */
    ResponseEntity<Usuario> registrarUsuario(UsuarioDTO usuarioDto) throws Exception;

    /**
     * Obtención de todos los usuarios
     * @return List<UsuarioDTO>
     */
    List<UsuarioDTO> getUsuarios();

    /**
     * Modificación de los datos del usuario
     * @param usuarioDto Usuario a modificar
     * @return ResponseEntity<UsuarioDTO>
     */
    ResponseEntity<UsuarioDTO> modificarUsuario(UsuarioDTO usuarioDto);

    /**
     * Eliminación de usuario
     * @param id Identificador de usuario
     * @return ResponseEntity<UsuarioDTO>
     */
    ResponseEntity<String> eliminarUsuario(Long id);
    
}
