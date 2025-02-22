package com.backend.fichaapp.fichaambulancia.models.ubigeo.peru;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ubigeo_peru_departments")
public class Departamento {
    @Id
    private String id;
    private String name;

}
