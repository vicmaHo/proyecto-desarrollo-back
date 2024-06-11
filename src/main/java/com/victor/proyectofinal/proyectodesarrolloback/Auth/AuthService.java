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
public class AuthService {

    private final UsuarioRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;



    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        Usuario userAux = userRepository.findByUsername(request.getUsername()).orElseThrow();

        String token = jwtService.getToken(user);

        return AuthResponse.builder()
            .token(token)
            .userType(userAux.getRol().name())
            .build();
    }

    
    public AuthResponse registerAdmin(RegisterRequest request) {
        return register(request, Rol.ADMINISTRADOR);
    }

	public AuthResponse registerUser(RegisterRequest request) {
		return register(request, Rol.SUPERVISOR);
	}
	
	/**
	 * Funcion general para recibir los registros de usuarios, almacenarlos y generar un token correspondiente
	 * @param request
	 * @param rol
	 * @return AuthResponse
	 */
	private AuthResponse register(RegisterRequest request, Rol rol) {
		Usuario user = Usuario.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.rol(rol)
				.build();
		
		userRepository.save(user);
		
		return AuthResponse.builder()
	            .token(jwtService.getToken(user))
	            .userType(user.getRol().name())
	            .build();
	}

}
