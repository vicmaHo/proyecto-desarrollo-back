package com.victor.proyectofinal.proyectodesarrolloback.Auth;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.victor.proyectofinal.proyectodesarrolloback.Auth.DTO.AuthResponse;
import com.victor.proyectofinal.proyectodesarrolloback.Auth.DTO.LoginRequest;
import com.victor.proyectofinal.proyectodesarrolloback.Auth.DTO.RegisterRequest;
import com.victor.proyectofinal.proyectodesarrolloback.jwt.JwtService;
import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Rol;
import com.victor.proyectofinal.proyectodesarrolloback.model.entity.Usuario;
import com.victor.proyectofinal.proyectodesarrolloback.model.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class AuthService {

    private final UsuarioRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;



    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        String token = jwtService.getToken(user);

        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .rol(Rol.ADMINISTRADOR)
            .build();

        userRepository.save(user);

        // Construyo la respuesta con el token
        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }

}
