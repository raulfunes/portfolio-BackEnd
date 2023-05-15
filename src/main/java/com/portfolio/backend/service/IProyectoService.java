/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyecto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author rauls
 */
public interface IProyectoService {
    
    
    public List<Proyecto> listarProyectos();
    public Optional<Proyecto> buscarProyecto(Long id);
    public Proyecto crearProyecto(Proyecto proy);
    public Proyecto modificarProyecto(Proyecto proy);
    public void eliminarProyecto(Long id);
}
