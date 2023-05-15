/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.service.impl;

import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.repository.UsuarioRepository;
import com.portfolio.backend.service.IUsuarioService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rauls
 */

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    public UsuarioRepository usuRepo;

        
    @Override
    public List<Usuario> listarUsuarios() {
        return usuRepo.findAll();
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuRepo.deleteById(id);
    }

    @Override
    public void crearUsuario(Usuario usu) {
        usuRepo.save(usu);
    }

    @Override
    public void modificarUsuario(Usuario usu) {
        usuRepo.save(usu);
    }

    @Override
    public Optional<Usuario> listarUsuario(Long id) {
        return usuRepo.findById(id);
    }

    @Override
    public Optional<Usuario> buscarUsuario(String username) {
        return usuRepo.findByUsername(username);
    }
    
}
