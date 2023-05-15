/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backend.service;

import com.portfolio.backend.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author rauls
 */
public interface IUsuarioService {
    
    public List<Usuario> listarUsuarios();
    public Optional<Usuario> listarUsuario(Long id);
    public Optional<Usuario> buscarUsuario(String username);
    public void eliminarUsuario(Long id);
    public void crearUsuario(Usuario usu);
    public void modificarUsuario(Usuario usu);
}
