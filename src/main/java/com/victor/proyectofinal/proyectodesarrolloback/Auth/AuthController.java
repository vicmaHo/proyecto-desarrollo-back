package com.victor.proyectofinal.proyectodesarrolloback.Auth;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.proyectofinal.proyectodesarrolloback.Auth.DTO.AuthResponse;
import com.victor.proyectofinal.proyectodesarrolloback.Auth.DTO.LoginRequest;
import com.victor.proyectofinal.proyectodesarrolloback.Auth.DTO.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173"}) // Agrego origines que tienen acceso al controlador
public class AuthController {

    private final AuthService authService;

    
    /**
     * Funcion encargada de manejar las peticiones post a auth/login, con la finalidad de recibir una peticion de login
     * en la aplicacion, hace uso del servicio de autenticación para procesar este login
     * @param request
     * @return AuthResponse
     */
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

    /**
     * Funcion encargada de manejar las peticiones post a auth/register/admin, con la finalidad de recibir el nuevo registro
     * de un administrador en la aplicación, hace uso del servicio de autenticacion para processar el nuevo registro
     * @param request
     * @return AuthResponse
     */
    @PostMapping(value = "register/admin")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.registerAdmin(request));
    }
    
    /**
     * Funcion encargada de manejar las peticiones post a auth/register/user, con la finalidad de recibir el nuevo registro
     * de un supervisor en la aplicación, hace uso del servicio de autenticacion para processar el nuevo registro
     * @param request
     * @return AuthResponse
     */
    @PostMapping("/register/user")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody RegisterRequest request){
    	
    	return ResponseEntity.ok(authService.registerUser(request));
    }

}
