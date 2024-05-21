package com.futurespace.proyecto_final_pvalverde.controller;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.entities.Proyecto;
import com.futurespace.proyecto_final_pvalverde.services.ProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/proyectos")//http://localhost:8080/proyectos
public class ProyectoController {

    //Conecta con el servicio
    @Autowired
    private ProyectoService proyectoService;

    //Insertar proyectos
    @PostMapping("/createProyecto")
    public ResponseEntity<Object> addProyecto(@Valid @RequestBody Proyecto proyecto){
        return proyectoService.addProyecto(proyecto);
    }

    //Conseguir todos los proyectos
    @GetMapping(path = "/getProyectos")
    public ResponseEntity<List<Proyecto>>getProyecto(){
        return proyectoService.getProyecto();
    }

    //Conseguir proyectos por id
    @GetMapping(path = "/getProyectos/{idProyecto}")
    public ResponseEntity<?>getProyectoById_proyecto(@PathVariable Integer idProyecto){
        return proyectoService.getProyectoById_proyecto(idProyecto);
    }

    //Actualizar por fecha de baja
    @PutMapping("/updateProyecto/{idProyecto}")
    public ResponseEntity<Object>updateFechaBajaProyecto(@PathVariable int idProyecto){
        return proyectoService.updateFechaBajaProyecto(idProyecto);
    }


}
