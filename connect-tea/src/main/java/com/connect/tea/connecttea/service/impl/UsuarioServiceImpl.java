package com.connect.tea.connecttea.service.impl;

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
    public ResponseEntity<Usuario> registrarUsuario(UsuarioDTO usuarioDto) {
        final Usuario usuario = UsuarioMapper.INSTANCE.usuarioDTOToUsuario(usuarioDto);
        return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }
    
}
