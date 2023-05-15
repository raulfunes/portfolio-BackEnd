/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backend.service;

import com.portfolio.backend.model.Estudio;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author rauls
 */
public interface IEstudioService {
    
    public List<Estudio> listarEstudios();
    public Optional<Estudio> buscarEstudio(Long id);
    public void crearEstudio(Estudio est);
    public void modificarEstudio(Estudio est);
    public void eliminarEstudio(Long id);
}
