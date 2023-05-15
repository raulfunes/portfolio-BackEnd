/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.service.impl;

import com.portfolio.backend.model.ExperienciaLaboral;
import com.portfolio.backend.repository.ExperienciaLaboralRepository;
import com.portfolio.backend.service.IExperienciaLaboralService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rauls
 */
@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService {
    
    @Autowired
    public ExperienciaLaboralRepository expRepo;

    @Override
    public List<ExperienciaLaboral> listarExperiencia() {
        return expRepo.findAll();
    }

    @Override
    public Optional<ExperienciaLaboral> buscarExperiencia(Long id) {
        return expRepo.findById(id);
    }

    @Override
    public ExperienciaLaboral agregarExperiencia(ExperienciaLaboral exp) {
        return expRepo.save(exp);
    }

    @Override
    public ExperienciaLaboral modificarExperiencia(ExperienciaLaboral exp) {
        return expRepo.save(exp);
    }

    @Override
    public void eliminarExperiencia(Long id) {
        expRepo.deleteById(id);
    }
    
    
}
