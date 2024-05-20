package com.futurespace.proyecto_final_pvalverde.controller;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.entities.EmpleadoProyecto;
import com.futurespace.proyecto_final_pvalverde.entities.Proyecto;
import com.futurespace.proyecto_final_pvalverde.services.EmpleadoProyectoService;
import com.futurespace.proyecto_final_pvalverde.services.EmpleadoService;
import com.futurespace.proyecto_final_pvalverde.services.ProyectoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("empleado_proyecto")
public class EmpleadoProyectoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private EmpleadoProyectoService empleadoProyectoService;

    @GetMapping("listaEmplProy")
    public ResponseEntity<List<EmpleadoProyecto>> getEmpleadoProyecto(){
        return empleadoProyectoService.getEmpleadoProyecto();
    }

   @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmpleadoProyecto>asignarEmpleadoAProyecto(@RequestBody Integer id_empleado, Integer id_proyecto, Empleado empleado, Proyecto proyecto, LocalDate fecha_alta){
        return empleadoProyectoService.asignarEmpleadoAProyecto(id_empleado, id_proyecto, empleado, proyecto, fecha_alta);
    }


    @Transactional
    @PostMapping("/insert")
    public ResponseEntity<EmpleadoProyecto> insertEmployeeProject(@RequestBody EmpleadoProyecto empleadoProyecto){
        return empleadoProyectoService.insertEmployeeProject(empleadoProyecto);
    }


}
