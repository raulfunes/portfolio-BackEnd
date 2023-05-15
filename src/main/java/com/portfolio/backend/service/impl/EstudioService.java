/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.service.impl;

import com.portfolio.backend.model.Estudio;
import com.portfolio.backend.repository.EstudioRepository;
import com.portfolio.backend.service.IEstudioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService implements IEstudioService{

    @Autowired
    public EstudioRepository estudioRepo;
    
    @Override
    public List<Estudio> listarEstudios() {
        return estudioRepo.findAll();
   }

    @Override
    public Optional<Estudio> buscarEstudio(Long id){
        return estudioRepo.findById(id);
    }
    
    @Override
    public void crearEstudio(Estudio est) {
        estudioRepo.save(est);
    }

    @Override
    public void modificarEstudio(Estudio newEst) {

        estudioRepo.save(newEst);
    }

    @Override
    public void eliminarEstudio(Long id) {
        estudioRepo.deleteById(id);
    }
    
}
