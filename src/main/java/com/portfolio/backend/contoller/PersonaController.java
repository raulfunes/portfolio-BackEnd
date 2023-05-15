/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.contoller;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IPersonaService;
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
@RequestMapping("/personas")
@CrossOrigin
public class PersonaController {
    
    @Autowired
    private IPersonaService persService;
    
    
    @GetMapping
    @ResponseBody
    public List<Persona> listarPersonas(){
        return persService.listarPersonas();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable Long id){
        Optional<Persona> persBD = persService.buscarPersona(id);
        
        if(!persBD.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(persBD.get());
    }

    
    @PostMapping
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona pers){
        persService.agregarPersona(pers);
        return ResponseEntity.accepted().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Persona> modificarPersona(@PathVariable Long id, @RequestBody Persona pers){
        Optional<Persona> persDB = persService.buscarPersona(id);
        
        if(!persDB.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        pers.setId(persDB.get().getId());
        persService.modificarPersona(pers);
        return ResponseEntity.ok(persService.modificarPersona(pers));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Long id){
       persService.borrarPersona(id);
       return ResponseEntity.accepted().build();
    }
}
