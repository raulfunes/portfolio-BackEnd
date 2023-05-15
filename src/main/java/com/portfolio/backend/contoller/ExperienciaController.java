/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.contoller;

import com.portfolio.backend.model.Estudio;
import com.portfolio.backend.model.ExperienciaLaboral;
import com.portfolio.backend.service.IExperienciaLaboralService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200/") 
public class ExperienciaController {
    
    @Autowired
    public IExperienciaLaboralService expServi;
    
    @GetMapping
    @ResponseBody
    public List<ExperienciaLaboral> listarEExperiencia(){
        return expServi.listarExperiencia();
    }
    
    @PostMapping
    public ResponseEntity<ExperienciaLaboral> agregarExperiencia(@RequestBody ExperienciaLaboral exp){
        expServi.agregarExperiencia(exp);
        return ResponseEntity.accepted().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ExperienciaLaboral> modificarExperiencia(@PathVariable Long id, @RequestBody ExperienciaLaboral exp){
        Optional<ExperienciaLaboral> expBD = expServi.buscarExperiencia(id);
        
        if (!expBD.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        exp.setId(expBD.get().getId());
        expServi.modificarExperiencia(exp);
        return ResponseEntity.accepted().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ExperienciaLaboral> eliminarExperiencia(@PathVariable Long id){
        expServi.eliminarExperiencia(id);
        return ResponseEntity.accepted().build();
    }
}
