package com.backend.fichaapp.fichaambulancia.services.users;

import com.backend.fichaapp.fichaambulancia.models.users.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario);
    public Optional<Usuario> obtenerUsuario(long id);
    public Optional<Usuario> update(Usuario usuario, Long id);
    public List<Usuario> usuariosPorAceptar();
    public Page<Map<String,Object>> buscarUsuario(String buscar, String estado, Pageable pageable);
    public Page<Map<String,Object>> listausuarios(String estado,Pageable pageable);
    public Page<Map<String,Object>> listausuariosInhabilitados(Pageable pageable);
    public Map<String,Object> buscarPorDni(int dni);
    Page<Usuario> findAll(Pageable pageable);
    public Usuario getUsuario(Usuario usuarioFront, Optional<Usuario> usuarioOptional);
//    public UsuarioDto guardarUsuarioConBaseyRol(UsuarioDto usuarioDto, List<BaseSamu> baseSamus, Rol rol);
//    public ResponseEntity<?> asignarbase(List<BaseSamu> baseSamus, long id );
//    public UsuarioDto guardarUsuarioConbase(List<BaseSamu> baseSamus, long id );
}
