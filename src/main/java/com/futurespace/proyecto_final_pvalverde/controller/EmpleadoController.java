package com.futurespace.proyecto_final_pvalverde.controller;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")//http://localhost:8080/empleado
public class EmpleadoController {

    //Conecta con el servicio
    @Autowired
    private EmpleadoService empleadoService;


    @PostMapping
    public ResponseEntity<Object> addEmpleado(@RequestBody Empleado empleado){
        return empleadoService.addEmpleado(empleado);
    }


    @GetMapping
    public List<Empleado> getEmpleado(){
        return empleadoService.getEmpleado();
    }





}
