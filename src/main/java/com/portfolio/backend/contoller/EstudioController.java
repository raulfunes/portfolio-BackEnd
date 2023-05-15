/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.contoller;

import com.portfolio.backend.model.Estudio;
import com.portfolio.backend.service.IEstudioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rauls
 */
@RestController
@RequestMapping("/estudios")
@CrossOrigin
public class EstudioController {
    
    @Autowired
    public IEstudioService estServ;
    
    @GetMapping
    @ResponseBody
    public List<Estudio> listarEstudios(){
        return estServ.listarEstudios();
    }
    
    @PostMapping
    public ResponseEntity<Estudio> agregarEstudio(@RequestBody Estudio est){
        estServ.crearEstudio(est);
        return ResponseEntity.accepted().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Estudio> modificarEstudio(@PathVariable Long id, @RequestBody Estudio est){
        Optional<Estudio> estBD = estServ.buscarEstudio(id);
        
        if (!estBD.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        est.setId(estBD.get().getId());
        estServ.modificarEstudio(est);
        return ResponseEntity.accepted().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Estudio> eliminarEstudio(@PathVariable Long id){
        estServ.eliminarEstudio(id);
        return ResponseEntity.accepted().build();
    }
}
