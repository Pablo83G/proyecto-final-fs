package com.futurespace.proyecto_final_pvalverde.services;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.repositories.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    //Conecta con el repositorio con el Autowired
    //Inyectar como dependencia
    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;

    //CONSTRUCTOR
    public EmpleadoService() {}

    //MÉTODOS:

    // Insertar datos
    public ResponseEntity<Object> addEmpleado(Empleado empleado){
        ResponseEntity<Object> resp = null;
        try{
            Empleado empl = iEmpleadoRepository.save(empleado);
            resp = new ResponseEntity<>(empl, HttpStatus.OK);
            return resp;
        }catch(DataIntegrityViolationException excep){
            resp = new ResponseEntity<>("Ha habido un error", HttpStatus.BAD_REQUEST);

            System.out.print("Error: " + excep.getMessage());
            return resp;

        }
    }

    //Conseguir datos
    public ResponseEntity<List<Empleado>> getEmpleado(){
        List<Empleado> emplList = iEmpleadoRepository.findAll();
        return new ResponseEntity<>(emplList, HttpStatus.OK);

    }

    //Borrar datos
    public ResponseEntity<Object> deleteIdEmpleado(int id_empleado){
        ResponseEntity<Object> resp = null;
        //Optional<Empleado> empleadoId = iEmpleadosRepositorio.findById(id_empleado);
        iEmpleadoRepository.deleteById(id_empleado);
        resp = new ResponseEntity<>("Empleado eliminado correctamente", HttpStatus.OK);
        return resp;
    }
//Borrar por Nif


}
