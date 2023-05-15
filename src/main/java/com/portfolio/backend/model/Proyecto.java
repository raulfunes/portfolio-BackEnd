/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author rauls
 */

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Proyecto {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column(name = "proyecto_id")
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
    private String sub_titulo;
    
    @Column(nullable = false)
    private String descripcion;
    
    private String imagen;
    
    private String link_repo;
    
    private String link_deploy;
    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;
    
    
    @ManyToMany
    @JoinTable(name = "proyectos_tecnologias", 
            joinColumns = @JoinColumn(name = "proyecto_id", referencedColumnName = "proyecto_id"), 
            inverseJoinColumns = @JoinColumn(name = "tecnologia_id", referencedColumnName = "tecnologia_id"))
    private Set<Tecnologia> tecnologias = new HashSet<>();
}
