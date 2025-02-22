package com.backend.fichaapp.fichaambulancia.services.ubigeo.peru;

import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Departamento;
import com.backend.fichaapp.fichaambulancia.repositories.ubigeo.peru.DepartamentoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements GenericServiceUbigeo<Departamento>{
    private DepartamentoRepositorio departamentoRepositorio;
    DepartamentoServiceImpl(DepartamentoRepositorio departamentoRepositorio){
        this.departamentoRepositorio = departamentoRepositorio;
    }
    @Override
    public Optional<Departamento> findById(String id) {
        return departamentoRepositorio.findById(id);
    }

    @Override
    public List<Departamento> findAll() {
        return departamentoRepositorio.findAll();
    }

    @Override
    public List<Departamento> findByName(String nombre) {
        return departamentoRepositorio.findByName(nombre);
    }
}
