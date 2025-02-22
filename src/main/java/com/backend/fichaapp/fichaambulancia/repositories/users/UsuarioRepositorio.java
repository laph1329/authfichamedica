package com.backend.fichaapp.fichaambulancia.repositories.users;

import com.backend.fichaapp.fichaambulancia.models.users.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByEmail(String email);

    public Optional<Usuario> findByUsernameOrEmail(String username, String email);

    public Optional<Usuario> findByUsername(String username);

    public Boolean existsByUsername(String username);
    Optional<Usuario> findByUsernameAndIdNot(String username, Long id);
    Optional<Usuario> findByEmailAndIdNot(String email, Long id);
    Optional<Usuario> findByDniAndIdNot(int dni, Long id);
    Optional<Usuario> findByCodigoAndIdNot(String codigo, Long id);
    Optional<Usuario> findByTelefonoAndIdNot(int telefono, Long id);

    public Boolean existsByEmail(String email);

    public Boolean existsByDni(int dni);

    public Boolean existsByCodigo(String codigo);

    public List<Usuario> findAll();
    Page<Usuario> findAll(Pageable pageable);

    @Query(value = "select * from usuarios where id=?1", nativeQuery = true)
    public Usuario obtenerUsuario(long id);

    @Query(value = "select * from usuarios where username=?1", nativeQuery = true)
    public Usuario obtenerUsuarioUser(String usuario);

    @Query(value = "select*from usuarios where condicion='pendiente' or condicion IS NULL or condicion='' order by created_at desc", nativeQuery = true)
    public List<Usuario> usuariosPorAceptar();

    @Query(value = "select * from usuarios where estado != 'PENDIENTE' and estado=?2 and nombre like %?1% or dni like %?1% or codigo like %?1% or apellido like %?1% order by apellido", nativeQuery = true)
    public Page<Map<String, Object>> buscarUsuario(String buscar, String estado, Pageable pageable);

    @Query(value = "select * from usuarios where estado != 'PENDIENTE' and estado=?1", nativeQuery = true)
    public Page<Map<String, Object>> listausuarios(String estado, Pageable pageable);

    @Query(value = "select * from usuarios where estado = 'INACTIVO'", nativeQuery = true)
    public Page<Map<String, Object>> listausuariosInhabilitados(Pageable pageable);

    @Query(value = "select * from usuarios where dni=?1", nativeQuery = true)
    public Map<String, Object> buscarPorDni(int dni);
}
