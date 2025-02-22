package com.backend.fichaapp.fichaambulancia.services.ubigeo.peru;

import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Provincia;

import java.util.List;

public interface ProvinciaService {
    List<Provincia> findByDepartamentoId(String departamentoId);
}
