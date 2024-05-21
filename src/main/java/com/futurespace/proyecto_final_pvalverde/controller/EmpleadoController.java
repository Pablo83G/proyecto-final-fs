package com.futurespace.proyecto_final_pvalverde.controller;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.services.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")//http://localhost:8080/empleados
public class EmpleadoController {

    //Conecta con el servicio
    @Autowired
    EmpleadoService empleadoService;


    //Insertar empleados
    @PostMapping("/createEmpleado")
    public ResponseEntity<Object> addEmpleado(@Valid @RequestBody Empleado empleado){
        return empleadoService.addEmpleado(empleado);
    }

    //Conseguir empleados
    @GetMapping("/getEmpleados")
    public ResponseEntity<List<Empleado>> getEmpleado(){
        return empleadoService.getEmpleado();
    }


    //Conseguir empleados por id
    @GetMapping("/getEmpleados/{idEmpleado}")
    public ResponseEntity<?> getByIdEmpleado(@PathVariable Integer idEmpleado){
        return empleadoService.getByIdEmpleado(idEmpleado);
    }


    //Borrar usuario
    @DeleteMapping (path = "deleteById/{idEmpleado}")
    public ResponseEntity<Object> deleteIdEmpleado(@PathVariable int idEmpleado){
        return empleadoService.deleteIdEmpleado(idEmpleado);
    }

    //Actualizar fecha de baja
    @PutMapping("/udpdateEmpleado/{id_empleado}")
    public ResponseEntity<Object> updateFechaBajaEmpleado(@PathVariable int id_empleado) {
        return empleadoService.updateFechaBajaEmpleado(id_empleado);
    }

}
