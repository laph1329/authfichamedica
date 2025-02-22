package com.backend.fichaapp.fichaambulancia.services.ubigeo.peru;

import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Distrito;
import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.DistritoResumen;

import java.util.List;

public interface DistritoService {
    List<Distrito> findByProvinciaIdAndDepartamentoId(String provinciaId, String departamentoId);
    public List<DistritoResumen> findAllBy();
}
