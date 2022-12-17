package com.connect.tea.connecttea.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.connect.tea.connecttea.dto.UsuarioDTO;
import com.connect.tea.connecttea.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDto);
    List<UsuarioDTO> usuarioToUsuarioDTO(List<Usuario> usuario);
    List<Usuario> usuarioDTOToUsuario(List<UsuarioDTO> usuarioDto);
    
}
