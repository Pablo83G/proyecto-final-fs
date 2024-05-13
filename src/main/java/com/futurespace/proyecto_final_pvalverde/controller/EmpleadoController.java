package com.futurespace.proyecto_final_pvalverde.controller;

import com.futurespace.proyecto_final_pvalverde.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleado")//http://localhost:8080/empleado
public class EmpleadoController {

    //Conecta con el servicio
    @Autowired
    private EmpleadoService empleadoService;




}
