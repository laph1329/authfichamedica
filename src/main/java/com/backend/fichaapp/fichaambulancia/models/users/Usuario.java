package com.backend.fichaapp.fichaambulancia.models.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotNull
    private int dni;
    private String tipo_codigo;
    @Column(unique = true)
    private String codigo;
    @NotBlank
    @Size(min = 1, max = 50)
    private String nombre;
    @NotBlank
    @Size(min = 1, max = 50)
    private String apellido;
    @Column(unique = true)
    @NotBlank
    @Size(min = 1, max = 50)
    private String username;
    @Column(unique = true)
    @NotBlank
    @Size(min = 1, max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(min = 1, max = 50)
    private String password;
    @NotBlank
    @Size(min = 1, max = 50)
    private String region;
    @NotBlank
    @Size(min = 1, max = 50)
    private String provincia;
    @NotBlank
    @Size(min = 1, max = 50)
    private String distrito;
    @NotBlank
    @Size(min = 1, max = 50)
    private String colegiatura;
    @NotBlank
    @Size(min = 1, max = 50)
    private String estado;
    @NotBlank
    @Size(min = 1, max = 50)
    private String condicion;
    @Column(unique = true)
    @NotNull
    private int telefono;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "rol_id"})})
    private List<Rol> roles;

    public Usuario(){
        this.roles= new ArrayList<>();
    }
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateAt = new Date();
    }
}
