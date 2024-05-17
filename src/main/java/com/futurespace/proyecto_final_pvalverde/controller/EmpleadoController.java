package com.futurespace.proyecto_final_pvalverde.controller;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/empleados")//http://localhost:8080/empleados
public class EmpleadoController {

    //Conecta con el servicio
    @Autowired
    EmpleadoService empleadoService;


    @PostMapping("/createEmpleado")
    public ResponseEntity<Object> addEmpleado(@RequestBody Empleado empleado){
        return empleadoService.addEmpleado(empleado);
    }


    @GetMapping("/getEmpleados")
    public ResponseEntity<List<Empleado>> getEmpleado(){
        return empleadoService.getEmpleado();
    }



    @GetMapping("/getEmpleados/{id_empleado}")
    public ResponseEntity<?> getById_empleado(@PathVariable Integer id_empleado){
        return empleadoService.getById_empleado(id_empleado);
    }

    // Actualizar la información sobre los empleados
   /* @PutMapping (path = "updateEmpleado/{id_empleado}")
   //public ResponseEntity<Empleado> updateEmpleado(@PathVariable int id_empleado, @Validated @RequestBody UpdateUserDetailsRequestModel userDetails)
    public ResponseEntity<Object> updateEmpleado(@RequestBody Empleado empleado, @PathVariable int id_empleado) {

        return empleadoService.updateEmpleado(empleado, id_empleado);
    }*/

    //Borrar usuario
    @DeleteMapping (path = "deleteById/{id_empleado}")
    public ResponseEntity<Object> deleteIdEmpleado(@PathVariable int id_empleado){
        return empleadoService.deleteIdEmpleado(id_empleado);
    }

    //Actualizar fecha de baja
    @PutMapping("/udpdateEmpleado/{id_empleado}")
    public ResponseEntity<Object> updateFechaBajaEmpleado(@PathVariable int id_empleado) {
        return empleadoService.updateFechaBajaEmpleado(id_empleado);
    }




}
