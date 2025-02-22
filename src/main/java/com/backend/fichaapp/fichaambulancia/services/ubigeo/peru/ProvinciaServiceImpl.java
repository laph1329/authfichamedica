package com.backend.fichaapp.fichaambulancia.services.ubigeo.peru;

import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Provincia;
import com.backend.fichaapp.fichaambulancia.repositories.ubigeo.peru.ProvinciaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaServiceImpl implements GenericServiceUbigeo<Provincia>, ProvinciaService{
    private ProvinciaRepositorio provinciaRepositorio;
    ProvinciaServiceImpl(ProvinciaRepositorio provinciaRepositorio){
        this.provinciaRepositorio = provinciaRepositorio;
    }
    @Override
    public Optional<Provincia> findById(String id) {
        return provinciaRepositorio.findById(id);
    }

    @Override
    public List<Provincia> findAll() {
        return provinciaRepositorio.findAll();
    }

    @Override
    public List<Provincia> findByName(String nombre) {
        return provinciaRepositorio.findByName(nombre);
    }

    @Override
    public List<Provincia> findByDepartamentoId(String departamentoId) {
        return provinciaRepositorio.findByDepartamentoId(departamentoId);
    }
}
