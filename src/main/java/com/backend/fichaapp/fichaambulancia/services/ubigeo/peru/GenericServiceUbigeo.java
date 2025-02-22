package com.backend.fichaapp.fichaambulancia.services.ubigeo.peru;

import java.util.List;
import java.util.Optional;

public interface GenericServiceUbigeo<T> {
    Optional<T> findById(String id);
    List<T> findAll();
    List<T> findByName(String nombre);
}
