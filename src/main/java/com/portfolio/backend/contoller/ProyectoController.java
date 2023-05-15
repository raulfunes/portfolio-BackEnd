/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.contoller;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.model.Tecnologia;
import com.portfolio.backend.service.IProyectoService;
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
@RequestMapping("/proyectos")
@CrossOrigin
public class ProyectoController {
    
    @Autowired
    public IProyectoService proyService;
    
    @GetMapping
    @ResponseBody
    public List<Proyecto> listarProyectos(){
        return proyService.listarProyectos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> buscarProyecto(@PathVariable Long id){
        Optional<Proyecto> tecBD = proyService.buscarProyecto(id);
        
        if(!tecBD.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(tecBD.get());
    }
    
    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proy){
        return ResponseEntity.ok(proyService.crearProyecto(proy));
    } 
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> modificarProyecto(@PathVariable Long id, @RequestBody Proyecto proy){
        Optional<Proyecto> proyBD = proyService.buscarProyecto(id);
        
        if (!proyBD.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        proy.setId(proyBD.get().getId());
        proyService.modificarProyecto(proy);
        return ResponseEntity.accepted().build();
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Tecnologia> eliminarProyecto(@PathVariable Long id){
        proyService.eliminarProyecto(id);
        return ResponseEntity.accepted().build();
    }
}
