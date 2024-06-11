package com.victor.proyectofinal.proyectodesarrolloback.Auth.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    
    String token;
    
    //Agrego el tipo de usuario 
    String userType;
}
