package com.futurespace.proyecto_final_pvalverde.controller;

import com.futurespace.proyecto_final_pvalverde.entities.EmpleadoProyecto;
import com.futurespace.proyecto_final_pvalverde.services.EmpleadoProyectoService;
import com.futurespace.proyecto_final_pvalverde.services.EmpleadoService;
import com.futurespace.proyecto_final_pvalverde.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("empleado_proyecto")
public class EmpleadoProyectoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private EmpleadoProyectoService empleadoProyectoService;

}
