/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.service.impl;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.repository.ProyectoRepository;
import com.portfolio.backend.service.IProyectoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rauls
 */

@Service
public class ProyectoService implements IProyectoService {
    
    @Autowired
    public ProyectoRepository proyRepo;

    @Override
    public List<Proyecto> listarProyectos() {
        return proyRepo.findAll();
    }

    @Override
    public Optional<Proyecto> buscarProyecto(Long id) {
        return proyRepo.findById(id);
    }

    @Override
    public Proyecto crearProyecto(Proyecto proy) {
        return proyRepo.save(proy);
    }

    @Override
    public Proyecto modificarProyecto(Proyecto proy) {
        return proyRepo.save(proy);
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyRepo.deleteById(id);
    }
    
    
}
