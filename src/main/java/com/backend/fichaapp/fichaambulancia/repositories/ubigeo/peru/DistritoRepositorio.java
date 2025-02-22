package com.backend.fichaapp.fichaambulancia.repositories.ubigeo.peru;

import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Distrito;
import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.DistritoResumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistritoRepositorio extends JpaRepository<Distrito, String> {
    List<Distrito> findByName(String nombre);
    @Query(value="SELECT * FROM `ubigeo_peru_districts` WHERE province_id=?1 AND department_id= ?2",nativeQuery = true)
    List<Distrito> findByProvinciaIdAndDepartamentoId(String provinciaId, String departamentoId);
    List<DistritoResumen> findAllBy();
}
