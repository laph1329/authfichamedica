package com.backend.fichaapp.fichaambulancia.controller.ubigeo.peru;

import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Departamento;
import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Distrito;
import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.DistritoResumen;
import com.backend.fichaapp.fichaambulancia.models.ubigeo.peru.Provincia;
import com.backend.fichaapp.fichaambulancia.services.ubigeo.peru.DistritoService;
import com.backend.fichaapp.fichaambulancia.services.ubigeo.peru.GenericServiceUbigeo;
import com.backend.fichaapp.fichaambulancia.services.ubigeo.peru.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ubigeo")
@CrossOrigin(origins = {"*"})
public class UbigeoController {

    @Autowired
    @Qualifier("distritoServiceImpl")
    private GenericServiceUbigeo<Distrito> genericDistritoService;

    @Autowired
    public DistritoService distritoService;

    @Autowired
    @Qualifier("provinciaServiceImpl")
    private GenericServiceUbigeo<Provincia> genericProvinciaService;

    @Autowired
    public ProvinciaService provinciaService;

    @Autowired
    @Qualifier("departamentoServiceImpl")
    private GenericServiceUbigeo<Departamento> genericDepartamentoService;

    @GetMapping(value = "/distrito/{id}")
    public ResponseEntity<?> getUbigeo(@PathVariable String id) {
        Optional<Distrito> distrito = genericDistritoService.findById(id);
        if (distrito.isPresent()) {
            return new ResponseEntity<>(distrito, HttpStatus.OK);
        }
        return new ResponseEntity<>("No existe Distrito con el ID : " + id, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/distrito")
    public ResponseEntity<?> distritoFindAll() {
        List<DistritoResumen> distrito = distritoService.findAllBy();
        if (distrito.isEmpty()) {
            return new ResponseEntity<>("No hay Distritos", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(distrito, HttpStatus.OK);
    }
    @GetMapping(value = "/distrito/nombre/{nombre}")
    public ResponseEntity<?> distritoFindByName(@PathVariable String nombre) {
        List<Distrito> distrito = genericDistritoService.findByName(nombre);
        if (distrito.isEmpty()) {
            return new ResponseEntity<>("No hay Distritos con el nombre : " + nombre, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(distrito, HttpStatus.OK);
    }

    @GetMapping(value = "/distrito/provincia/{provinciaId}/departamento/{departamentoId}")
    public ResponseEntity<?> distritoFindByProvinciaIdAndDepartamentoId(@PathVariable String provinciaId, @PathVariable String departamentoId) {
        Optional<Departamento> departamento = genericDepartamentoService.findById(departamentoId);
        if (departamento.isEmpty()) {
            return new ResponseEntity<>("No existe Departamento con el ID : " + departamentoId, HttpStatus.NOT_FOUND);
        }
        Optional<Provincia> provincia = genericProvinciaService.findById(provinciaId);
        if (provincia.isEmpty()) {
            return new ResponseEntity<>("No existe Provincia con el ID : " + provinciaId, HttpStatus.NOT_FOUND);
        }
        List<Distrito> distrito = distritoService.findByProvinciaIdAndDepartamentoId(provinciaId, departamentoId);
        if (distrito.isEmpty()) {
            return new ResponseEntity<>("No hay Distritos con la Provincia ID : " + provinciaId + " y Departamento ID : " + departamentoId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(distrito, HttpStatus.OK);
    }

    @GetMapping(value = "/provincia/{id}")
    public ResponseEntity<?> getProvincia(@PathVariable String id) {
        Optional<Provincia> provincia = genericProvinciaService.findById(id);
        if (provincia.isPresent()) {
            return new ResponseEntity<>(provincia, HttpStatus.OK);
        }
        return new ResponseEntity<>("No existe Provincia con el ID : " + id, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/provincia")
    public ResponseEntity<?> provinciaFindAll() {
        List<Provincia> provincia = genericProvinciaService.findAll();
        if (provincia.isEmpty()) {
            return new ResponseEntity<>("No hay Provincias", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(provincia, HttpStatus.OK);
    }

    @GetMapping(value = "/provincia/nombre/{nombre}")
    public ResponseEntity<?> provinciaFindByName(@PathVariable String nombre) {
        List<Provincia> provincia = genericProvinciaService.findByName(nombre);
        if (provincia.isEmpty()) {
            return new ResponseEntity<>("No hay Provincias con el nombre : " + nombre, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(provincia, HttpStatus.OK);
    }

    @GetMapping(value = "/provincia/departamento/{departamentoId}")
    public ResponseEntity<?> provinciaFindByDepartamentoId(@PathVariable String departamentoId) {
        List<Provincia> provincia = provinciaService.findByDepartamentoId(departamentoId);
        if (provincia.isEmpty()) {
            return new ResponseEntity<>("No hay Provincias con el Departamento ID : " + departamentoId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(provincia, HttpStatus.OK);
    }

    @GetMapping(value = "/departamento/{id}")
    public ResponseEntity<?> getDepartamento(@PathVariable String id) {
        Optional<Departamento> departamento = genericDepartamentoService.findById(id);
        if (departamento.isPresent()) {
            return new ResponseEntity<>(departamento, HttpStatus.OK);
        }
        return new ResponseEntity<>("No existe Departamento con el ID : " + id, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/departamento")
    public ResponseEntity<?> departamentoFindAll() {
        List<Departamento> departamento = genericDepartamentoService.findAll();
        if (departamento.isEmpty()) {
            return new ResponseEntity<>("No hay Departamentos", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    @GetMapping(value = "/departamento/nombre/{nombre}")
    public ResponseEntity<?> departamentoFindByName(@PathVariable String nombre) {
        List<Departamento> departamento = genericDepartamentoService.findByName(nombre);
        if (departamento.isEmpty()) {
            return new ResponseEntity<>("No hay Departamentos con el nombre : " + nombre, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

}
