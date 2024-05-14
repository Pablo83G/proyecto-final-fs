package com.futurespace.proyecto_final_pvalverde.services;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.repositories.IEmpleadosRepositorio;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    //Conecta con el repositorio con el Autowired
    //Inyectar como dependencia
    @Autowired
    private IEmpleadosRepositorio iEmpleadosRepositorio;

    //CONSTRUCTOR
    public EmpleadoService() {}

    //MÉTODOS:

    // Insertar datos
    public ResponseEntity<Object> addEmpleado(Empleado empleado){
        ResponseEntity<Object> r = null;
        try{
            Empleado e = iEmpleadosRepositorio.save(empleado);
            r = new ResponseEntity<>(e, HttpStatus.OK);
            return r;
        }catch(DataIntegrityViolationException e){
            r = new ResponseEntity<>("Ha habido un error", HttpStatus.BAD_REQUEST);

            System.out.print("Error: " + e.getMessage());
            return r;

        }
    }

    //Conseguir datos
    public List<Empleado> getEmpleado(){ return iEmpleadosRepositorio.findAll();
    }

}
