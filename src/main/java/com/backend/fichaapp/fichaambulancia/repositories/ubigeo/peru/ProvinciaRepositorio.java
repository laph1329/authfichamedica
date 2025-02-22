package com.backend.fichaapp.fichaambulancia.repositories.ubigeo.peru;

import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinciaRepositorio extends JpaRepository<Provincia, String> {
    public List<Provincia> findByName(String nombre);
    List<Provincia> findByDepartamentoId(String departamentoId);
}
