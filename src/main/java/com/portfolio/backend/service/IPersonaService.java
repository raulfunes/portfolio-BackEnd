/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backend.service;

import com.portfolio.backend.model.Persona;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author rauls
 */
public interface IPersonaService {
    
    public List<Persona> listarPersonas();
    public Optional<Persona> buscarPersona(Long id);
    public void agregarPersona(Persona pers);
    public Persona modificarPersona(Persona pers);
    public void borrarPersona(Long id);
}
