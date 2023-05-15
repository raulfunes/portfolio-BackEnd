/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.service.impl;

import com.portfolio.backend.model.Tecnologia;
import com.portfolio.backend.repository.TecnologiaRepository;
import com.portfolio.backend.service.ITecnologiaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rauls
 */
@Service
public class TecnologiaService implements ITecnologiaService{
    
    @Autowired
    public TecnologiaRepository tecRepo;

    @Override
    public List<Tecnologia> listarTecnologias() {
        return tecRepo.findAll();
    }

    @Override
    public Optional<Tecnologia> buscarTecnologia(Long id) {
        return tecRepo.findById(id);
    }

    @Override
    public void crearTecnologia(Tecnologia tec) {
        tecRepo.save(tec);
    }

    @Override
    public void modificarTecnologia(Tecnologia tec) {
        tecRepo.save(tec);
    }

    @Override
    public void eliminarTecnologia(Long id) {
        tecRepo.deleteById(id);
    }
}
