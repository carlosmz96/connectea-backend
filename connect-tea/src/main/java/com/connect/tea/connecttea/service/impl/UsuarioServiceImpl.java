package com.connect.tea.connecttea.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.connect.tea.connecttea.dto.UsuarioDTO;
import com.connect.tea.connecttea.mapper.UsuarioMapper;
import com.connect.tea.connecttea.model.Usuario;
import com.connect.tea.connecttea.repository.UsuarioRepository;
import com.connect.tea.connecttea.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    /** UsuarioRepository */
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<Usuario> registrarUsuario(UsuarioDTO usuarioDto) throws Exception {
        Usuario usuario = usuarioRepository.findByEmail(usuarioDto.getEmail());

        if (Objects.nonNull(usuario)) {
            throw new Exception("Ya existe un usuario con ese correo.");
        } else {
            usuario = UsuarioMapper.INSTANCE.usuarioDTOToUsuario(usuarioDto);
        }
        
        return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @Override
    public List<UsuarioDTO> getUsuarios() {
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuarioRepository.findAll());
    }

    @Override
    public ResponseEntity<UsuarioDTO> modificarUsuario(UsuarioDTO usuarioDto) {
        final Usuario modificado = usuarioRepository.save(UsuarioMapper.INSTANCE.usuarioDTOToUsuario(usuarioDto));
        return new ResponseEntity<>(UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(modificado), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
        return new ResponseEntity<String>("Usuario eliminado correctamente.", HttpStatus.OK);
    }
    
}
