/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.contoller;

import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.service.IUsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rauls
 */

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuService;
    
    
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuService.listarUsuarios();
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> listarUsuario(@PathVariable Long id){
        Optional<Usuario> usu = usuService.listarUsuario(id);
        
        if(!usu.isPresent()){
           return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(usu.get());
    }
    
    @GetMapping("/{username}")
    public ResponseEntity<Usuario> buscarUsuarioPorUsername(@PathVariable String username){
        Optional<Usuario> usu = usuService.buscarUsuario(username);
        
        if(!usu.isPresent()){
           return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(usu.get());
    }
    
    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@Validated @RequestBody Usuario usu){
        usuService.crearUsuario(usu);
        return ResponseEntity.ok(usu);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long id, @Validated @RequestBody Usuario usu){
        Optional<Usuario> usuBD = usuService.listarUsuario(id);
        
        if(!usuBD.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        
        usu.setId(usuBD.get().getId());
        usuService.modificarUsuario(usu);
        
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable Long id){
        usuService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
    
}
