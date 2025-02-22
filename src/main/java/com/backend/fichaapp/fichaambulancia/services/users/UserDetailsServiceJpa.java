package com.backend.fichaapp.fichaambulancia.services.users;

import com.backend.fichaapp.fichaambulancia.models.users.Usuario;
import com.backend.fichaapp.fichaambulancia.repositories.users.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceJpa implements UserDetailsService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepositorio.findByUsername(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Usuario %s no encontrado", username));
        }
        Usuario user = usuario.orElseThrow();
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(username,
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }
}
