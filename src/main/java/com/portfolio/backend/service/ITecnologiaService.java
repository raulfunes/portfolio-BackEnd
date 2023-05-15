/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backend.service;

import com.portfolio.backend.model.Tecnologia;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author rauls
 */
public interface ITecnologiaService {
    
    public List<Tecnologia> listarTecnologias();
    public Optional<Tecnologia> buscarTecnologia(Long id);
    public void crearTecnologia(Tecnologia tec);
    public void modificarTecnologia(Tecnologia tec);
    public void eliminarTecnologia(Long id);
}
