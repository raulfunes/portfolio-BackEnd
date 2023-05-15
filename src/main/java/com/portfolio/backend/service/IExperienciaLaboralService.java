/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backend.service;

import com.portfolio.backend.model.ExperienciaLaboral;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author rauls
 */
public interface IExperienciaLaboralService {
    
    public List<ExperienciaLaboral> listarExperiencia();
    public Optional<ExperienciaLaboral> buscarExperiencia(Long id);
    public ExperienciaLaboral agregarExperiencia(ExperienciaLaboral exp);
    public ExperienciaLaboral modificarExperiencia(ExperienciaLaboral exp);
    public void eliminarExperiencia(Long id);
}
