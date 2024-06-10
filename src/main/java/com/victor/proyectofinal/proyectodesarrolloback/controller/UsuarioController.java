package com.victor.proyectofinal.proyectodesarrolloback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    /**
	 * Cuando se hace una peticion get al endpoint especificado con un id en el path, se hace uso
     * del servicio con dicho id para devolver el usuario correspondiente
	 * @return UsuarioDTO
	 */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUser(@PathVariable(name = "id") Integer id){

        System.out.println("ID: "+id);

        UsuarioDTO user = service.getUser(id);

        return ResponseEntity.ok(user);
    }

    
    /**
	 * Cuando se hace una peticion put al endpoint del controlador, y se manda un body que contiene un
     * los datos nuevos de un usuario, se hace uso del servicio para actualizar el usuario correspondiente
     * @param UsuarioRequest
	 * @return UsuarioResponse
	 */
    @PutMapping
    public UsuarioResponse updateUser(@RequestBody UsuarioRequest request){
        
        return service.updateUser(request);
    }


    /**
     * Cuando se hace una peticion delete al endpoint especificado /{id}, se elimina el usuario, dando comprender
     * de que se realizo una devolucion del mismo
     * @return String(devolucion exitosa)
     * */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable(name = "id") Integer id){
        service.eliminar(id);
    }
}
