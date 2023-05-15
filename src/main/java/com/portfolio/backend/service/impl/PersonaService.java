/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.service.impl;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.repository.PersonaRepository;
import com.portfolio.backend.service.IPersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rauls
 */

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> listarPersonas() {
        return persoRepo.findAll();
    }
    
    @Override
    public Optional<Persona> buscarPersona(Long id) {
        return persoRepo.findById(id);
    }

    @Override
    public void agregarPersona(Persona pers) {
        persoRepo.save(pers);
    }

    @Override
    public Persona modificarPersona(Persona pers) {
        return persoRepo.save(pers);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    
    
}
