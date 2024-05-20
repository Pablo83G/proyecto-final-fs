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
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/proyectos")//http://localhost:8080/proyectos
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping("/createProyecto")
    public ResponseEntity<Object> addProyecto(@Valid @RequestBody Proyecto proyecto){
        return proyectoService.addProyecto(proyecto);
    }

    @GetMapping(path = "/getProyectos")
    public ResponseEntity<List<Proyecto>>getProyecto(){
        return proyectoService.getProyecto();
    }

    @GetMapping(path = "/getProyectos/{id_proyecto}")
    public ResponseEntity<?>getProyectoById_proyecto(@PathVariable Integer id_proyecto){
        return proyectoService.getProyectoById_proyecto(id_proyecto);
    }

    @PutMapping("/updateProyecto/{id_proyecto}")
    public ResponseEntity<Object>updateFechaBajaProyecto(@PathVariable int id_proyecto){
        return proyectoService.updateFechaBajaProyecto(id_proyecto);
    }


}
