/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.contoller.auth;

import com.portfolio.backend.config.JwtUtils;
import com.portfolio.backend.model.Persona;
import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.repository.PersonaRepository;
import com.portfolio.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author rauls
 */
@Service
@RequiredArgsConstructor
class AuthenticationService {
    
    
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuRepo;
    @Autowired
    private PersonaRepository persRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    public AuthenticationResponse register(RegisterRequest request){
        var pers = Persona.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .pais(request.getPais())
                .build();
        var user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .persona(persRepo.save(pers))
                .build();
        usuRepo.save(user);
        var jwtToken = jwtUtils.generateToken(user);
        
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    
    public AuthenticationResponse login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = usuRepo.findByUsername(request.getUsername());
        var jwtToken = jwtUtils.generateToken(user.get());
        
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
