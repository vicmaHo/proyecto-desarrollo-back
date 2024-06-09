package com.victor.proyectofinal.proyectodesarrolloback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioDTO;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioRequest;
import com.victor.proyectofinal.proyectodesarrolloback.controller.dto.UsuarioResponse;
import com.victor.proyectofinal.proyectodesarrolloback.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173"})
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUser(@PathVariable(name = "id") Integer id){

        System.out.println("ID: "+id);

        UsuarioDTO user = service.getUser(id);

        return ResponseEntity.ok(user);
    }

    @PutMapping
    public UsuarioResponse updateUser(@RequestBody UsuarioRequest request){
        
        return service.updateUser(request);
    }
}
