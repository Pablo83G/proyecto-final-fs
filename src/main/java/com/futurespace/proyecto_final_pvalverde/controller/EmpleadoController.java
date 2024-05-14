package com.futurespace.proyecto_final_pvalverde.controller;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")//http://localhost:8080/empleado
public class EmpleadoController {

    //Conecta con el servicio
    @Autowired
    private EmpleadoService empleadoService;


    @PostMapping("/createEmpleado")
    public ResponseEntity<Object> addEmpleado(@RequestBody Empleado empleado){
        return empleadoService.addEmpleado(empleado);
    }


    @GetMapping("/getEmpleado")
    public ResponseEntity<List<Empleado>> getEmpleado(){
        return empleadoService.getEmpleado();
    }

    // Actualizar la información sobre los usuarios
   /*
    @PutMapping (path = "/{userId}",

            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })

    public UserRest updateUser(@PathVariable String userId, @Validated @RequestBody UpdateUserDetailsRequestModel userDetails) {
        //Utilizamos el objeto de clase UserRest para tener sus atributos y métodos
        UserRest storeUserDetails = users.get(userId); // objeto datos almacenados
        storeUserDetails.setFirstname(userDetails.getFirstName()); // establecer nuevo nombre usando el objeto userDetails
        storeUserDetails.setLastname(userDetails.getLastName()); // establecer nuevo apellido
        users.put(userId, storeUserDetails); // actualizar usuarios para devolver la información almacenada

        return storeUserDetails;
    }
*/
    //Borrar usuario
    @DeleteMapping (path = "deleteById/{id_empleado}")
    public ResponseEntity<Object> deleteIdEmpleado(@PathVariable int id_empleado){
        return empleadoService.deleteIdEmpleado(id_empleado);
    }


}
