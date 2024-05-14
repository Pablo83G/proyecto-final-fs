package com.futurespace.proyecto_final_pvalverde.services;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.entities.Proyecto;
import com.futurespace.proyecto_final_pvalverde.repositories.IEmpleadoRepository;
import com.futurespace.proyecto_final_pvalverde.repositories.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {

    //Conecta con el repositorio con el Autowired
    //Inyectar como dependencia
    @Autowired
    private IProyectoRepository iProyectoRepository;

    //CONSTRUCTOR
    public ProyectoService() {}

    // Insertar datos
    public ResponseEntity<Object> addProyecto(Proyecto proyecto){
        ResponseEntity<Object> resp = null;
        try{
            Proyecto proy = iProyectoRepository.save(proyecto);
            resp = new ResponseEntity<>(proy, HttpStatus.OK);
            return resp;
        }catch(DataIntegrityViolationException excep){
            resp = new ResponseEntity<>("Ha habido un error", HttpStatus.BAD_REQUEST);

            System.out.print("Error: " + excep.getMessage());
            return resp;

        }
    }

    //Conseguir datos
    public ResponseEntity<List<Proyecto>> getProyecto(){
        List<Proyecto> proyList = iProyectoRepository.findAll();
        return new ResponseEntity<>(proyList, HttpStatus.OK);

    }
}
