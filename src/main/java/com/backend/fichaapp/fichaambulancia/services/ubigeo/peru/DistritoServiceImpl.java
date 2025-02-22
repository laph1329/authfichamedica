package com.backend.fichaapp.fichaambulancia.services.ubigeo.peru;

import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Distrito;
import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.DistritoResumen;
import com.backend.fichaapp.fichaambulancia.repositories.ubigeo.peru.DistritoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoServiceImpl implements GenericServiceUbigeo<Distrito>, DistritoService{
    private DistritoRepositorio distritoRepositorio;
    DistritoServiceImpl(DistritoRepositorio distritoRepositorio){
        this.distritoRepositorio = distritoRepositorio;
    }

    @Override
    public Optional<Distrito> findById(String id) {
        return distritoRepositorio.findById(id);
    }

    @Override
    public List<Distrito> findAll() {
        return distritoRepositorio.findAll();
    }

    @Override
    public List<DistritoResumen> findAllBy() {
        return distritoRepositorio.findAllBy();
    }

    @Override
    public List<Distrito> findByName(String nombre) {
        return distritoRepositorio.findByName(nombre);
    }

    @Override
    public List<Distrito> findByProvinciaIdAndDepartamentoId(String provinciaId, String departamentoId) {
        return distritoRepositorio.findByProvinciaIdAndDepartamentoId(provinciaId, departamentoId);
    }
}
