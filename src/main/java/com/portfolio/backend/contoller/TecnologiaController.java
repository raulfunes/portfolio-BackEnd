/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.contoller;

import com.portfolio.backend.model.Tecnologia;
import com.portfolio.backend.service.ITecnologiaService;
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
@RequestMapping("/tecnologia")
@CrossOrigin(origins = "http://localhost:4200/")
public class TecnologiaController {
    
    @Autowired
    public ITecnologiaService tecService;
    
    @GetMapping
    @ResponseBody
    public List<Tecnologia> listarTecnologias(){
        return tecService.listarTecnologias();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Tecnologia> buscarTecnologia(@PathVariable Long id){
        Optional<Tecnologia> tecBD = tecService.buscarTecnologia(id);
        
        if(!tecBD.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(tecBD.get());
    }
    
    @PostMapping
    public ResponseEntity<Tecnologia> crearTecnologia(@RequestBody Tecnologia tec){
        tecService.crearTecnologia(tec);
        return ResponseEntity.ok().build();
    } 
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Tecnologia> modificarTecnologia(@PathVariable Long id, @RequestBody Tecnologia tec){
        Optional<Tecnologia> tecBD = tecService.buscarTecnologia(id);
        
        if (!tecBD.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        tec.setId(tecBD.get().getId());
        tecService.modificarTecnologia(tec);
        return ResponseEntity.accepted().build();
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Tecnologia> eliminarTecnologia(@PathVariable Long id){
        tecService.eliminarTecnologia(id);
        return ResponseEntity.accepted().build();
    }
}
