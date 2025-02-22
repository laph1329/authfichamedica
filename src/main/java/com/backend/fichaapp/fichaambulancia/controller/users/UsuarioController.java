package com.backend.fichaapp.fichaambulancia.controller.users;

import com.backend.fichaapp.fichaambulancia.models.users.Usuario;
import com.backend.fichaapp.fichaambulancia.repositories.users.UsuarioRepositorio;
import com.backend.fichaapp.fichaambulancia.services.users.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = {"*"})
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value="/listar")
    public List<Usuario> obtenerUsuarios(){
        return usuarioRepositorio.findAll();
    }

    @GetMapping(value="/listar/page/{page}")
    public Page<Usuario> obtenerUsuariosPageable(@PathVariable Integer page ){
        Pageable pageable= PageRequest.of(page, 3);
        return usuarioService.findAll(pageable);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable long id){
        Optional<Usuario> usuario=usuarioService.obtenerUsuario(id);
        if(usuario.isPresent()){
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        }
        return new ResponseEntity<>("No existe el usuario con el ID : " + id,HttpStatus.NOT_FOUND);
    }

    @PostMapping(value="/registrar")
    public ResponseEntity<?> registrarUser(@Valid @RequestBody Usuario usuario, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errors.put(err.getField(), "El campo "+err.getField()+" "+err.getDefaultMessage());
            });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        if(usuarioRepositorio.existsByUsername(usuario.getUsername())) {
            return new ResponseEntity<>(Collections.singletonMap("error","Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioRepositorio.existsByEmail(usuario.getEmail())) {
            return new ResponseEntity<>(Collections.singletonMap("error","El email de usuario ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(usuarioRepositorio.existsByDni(usuario.getDni())){
            return new ResponseEntity<>(Collections.singletonMap("error","El D.N.I de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioRepositorio.existsByCodigo(usuario.getCodigo())){
            return new ResponseEntity<>(Collections.singletonMap("error","El Número de colegiatura ya existe"), HttpStatus.BAD_REQUEST);
        }
        //usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        usuario.setUsername(String.valueOf(usuario.getDni()));
        usuarioService.guardarUsuario(usuario);
//        usuarioRepositorio.save(usuario);
//        RolUsuario rolUsuario= new RolUsuario(usuarioService.obtenerUsuario(usuario.getId()).getId()  ,2);
//        rolUsuarioDao.save(rolUsuario);
        return new ResponseEntity<>(Collections.singletonMap("message", "¡Usuario registrado exitosamente!"),HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar/{id}")
    public ResponseEntity<?> actualizarusuario(@PathVariable long id, @Valid @RequestBody Usuario usuarioFront, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errors.put(err.getField(), "El campo "+err.getField()+" "+err.getDefaultMessage());
            });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        if(usuarioRepositorio.findByUsernameAndIdNot(usuarioFront.getUsername(), usuarioFront.getId()).isPresent()) {
            return new ResponseEntity<>(Collections.singletonMap("error","Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioRepositorio.findByEmailAndIdNot(usuarioFront.getEmail(), usuarioFront.getId()).isPresent()) {
            return new ResponseEntity<>(Collections.singletonMap("error","El email de usuario ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(usuarioRepositorio.findByDniAndIdNot(usuarioFront.getDni(), usuarioFront.getId()).isPresent()){
            return new ResponseEntity<>(Collections.singletonMap("error","El D.N.I de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioRepositorio.findByCodigoAndIdNot(usuarioFront.getCodigo(), usuarioFront.getId()).isPresent()){
            return new ResponseEntity<>(Collections.singletonMap("error","El Número de colegiatura ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioRepositorio.findByTelefonoAndIdNot(usuarioFront.getTelefono(), usuarioFront.getId()).isPresent()) {
            return new ResponseEntity<>(Collections.singletonMap("error","El número de teléfono ya existe"),HttpStatus.BAD_REQUEST);
        }


        Optional<Usuario> usuarioOptional=usuarioService.obtenerUsuario(id);
        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioService.getUsuario(usuarioFront, usuarioOptional);
            usuarioService.guardarUsuario(usuario);
            return new ResponseEntity<>(Collections.singletonMap("message", "¡Usuario actualizado exitosamente!"),HttpStatus.OK);
        }

        return new ResponseEntity<>(Collections.singletonMap("message", "No existe el usuario con el ID : " + id),HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable long id){
        Optional<Usuario> usuarioOptional=usuarioService.obtenerUsuario(id);
        if(usuarioOptional.isPresent()){
            usuarioRepositorio.deleteById(id);
            return new ResponseEntity<>("¡Usuario eliminado exitosamente!",HttpStatus.OK);
        }
        return new ResponseEntity<>(Collections.singletonMap("error","No existe usuario con id"+id),HttpStatus.NOT_FOUND);
    }


}
