package com.backend.fichaapp.fichaambulancia.repositories.ubigeo.peru;

import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepositorio extends JpaRepository<Departamento, String> {
    List<Departamento> findByName(String nombre);
}
