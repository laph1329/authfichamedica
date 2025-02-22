package com.backend.fichaapp.fichaambulancia.services.users;

import com.backend.fichaapp.fichaambulancia.dto.users.UsuarioDto;
import com.backend.fichaapp.fichaambulancia.models.users.Usuario;
import com.backend.fichaapp.fichaambulancia.repositories.users.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService{
//    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    UsuarioServiceImpl(UsuarioRepositorio usuarioRepositorio){
        this.usuarioRepositorio=usuarioRepositorio;
    }

//    @Autowired
//    private ModelMapper modelMapper;

    @Override
    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuario(long id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    @Transactional
    public Optional<Usuario> update(Usuario usuario, Long id){
        Optional<Usuario> usuarioOptional=usuarioRepositorio.findById(id);
        if(usuarioOptional.isPresent()) {
            Usuario usuarioAux = getUsuario(usuario, usuarioOptional);
            usuarioRepositorio.save(usuarioAux);
            return Optional.of(usuarioAux);
        }

        return usuarioOptional;
    }

    public Usuario getUsuario(Usuario usuarioFront, Optional<Usuario> usuarioOptional) {
        Usuario usuario= usuarioOptional.get();
        usuario.setDni(usuarioFront.getDni());
        usuario.setTipo_codigo(usuarioFront.getTipo_codigo());
        usuario.setCodigo(usuarioFront.getCodigo());
        usuario.setNombre(usuarioFront.getNombre());
        usuario.setApellido(usuarioFront.getApellido());
        usuario.setRegion(usuarioFront.getRegion());
        usuario.setProvincia(usuarioFront.getProvincia());
        usuario.setDistrito(usuarioFront.getDistrito());
        usuario.setColegiatura(usuarioFront.getColegiatura());
        usuario.setEmail(usuarioFront.getEmail());
        usuario.setUsername(usuarioFront.getUsername());
        usuario.setPassword(usuarioFront.getPassword());
        usuario.setEstado(usuarioFront.getEstado());
        usuario.setCondicion(usuarioFront.getCondicion());
        usuario.setTelefono(usuarioFront.getTelefono());
        return usuario;
    }

    @Override
    public List<Usuario> usuariosPorAceptar() {
        return usuarioRepositorio.usuariosPorAceptar();
    }

    @Override
    public Page<Map<String, Object>> buscarUsuario(String buscar, String estado, Pageable pageable) {
        return usuarioRepositorio.buscarUsuario(buscar, estado, pageable);
    }

    @Override
    public Page<Map<String, Object>> listausuarios(String estado, Pageable pageable) {
        return usuarioRepositorio.listausuarios(estado, pageable);
    }

    @Override
    public Page<Map<String, Object>> listausuariosInhabilitados(Pageable pageable) {
        return usuarioRepositorio.listausuariosInhabilitados(pageable);
    }

    @Override
    public Map<String, Object> buscarPorDni(int dni) {
        return usuarioRepositorio.buscarPorDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return this.usuarioRepositorio.findAll(pageable);
    }

//    @Override
//    public UsuarioDto guardarUsuarioConBaseyRol(UsuarioDto usuarioDto, List<BaseSamu> baseSamus, Rol rol) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<?> asignarbase(List<BaseSamu> baseSamus, long id) {
//        Optional<Usuario> o=usuarioRepositorio.findById(id);
//        if(!o.isPresent()){
//            return ResponseEntity.notFound().build();
//        }
//
//        Usuario usuario1=o.get();
//        baseSamus.forEach(e->{
//            usuario1.addBaseSamu(e);
//        });
//        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepositorio.save(usuario1));
//    }
//
//    @Override
//    public UsuarioDto guardarUsuarioConbase(List<BaseSamu> baseSamus, long id) {
//        return null;
//    }

//    private UsuarioDto mapearDto(Usuario usuario) {
//
//        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
//        return usuarioDto;
//    }
//    private Usuario mapearEntidad(UsuarioDto usuarioDto){
//        Usuario usuario=modelMapper.map(usuarioDto,Usuario.class);
//        return usuario;
//    }
}
