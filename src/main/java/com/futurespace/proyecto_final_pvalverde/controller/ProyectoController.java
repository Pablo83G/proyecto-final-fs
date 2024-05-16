package com.futurespace.proyecto_final_pvalverde.controller;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.entities.Proyecto;
import com.futurespace.proyecto_final_pvalverde.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/proyectos")//http://localhost:8080/proyectos
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @PostMapping("/createProyecto")
    public ResponseEntity<Object> addProyecto(@RequestBody Proyecto proyecto){
        return proyectoService.addProyecto(proyecto);
    }

    @GetMapping(path = "/getProyectos")
    public ResponseEntity<List<Proyecto>>getProyecto(){
        return proyectoService.getProyecto();
    }
}
