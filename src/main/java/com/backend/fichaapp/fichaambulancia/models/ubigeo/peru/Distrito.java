package com.backend.fichaapp.fichaambulancia.models.ubigeo.peru;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ubigeo_peru_districts")
public class Distrito {
    @Id
    private String id;
    private String name;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="province_id", nullable=false)
    private Provincia provincia;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Departamento departamento;
}
