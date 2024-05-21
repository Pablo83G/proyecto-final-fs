package com.futurespace.proyecto_final_pvalverde.services;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.entities.EmpleadoProyecto;
import com.futurespace.proyecto_final_pvalverde.entities.EmpleadoProyectoId;
import com.futurespace.proyecto_final_pvalverde.entities.Proyecto;
import com.futurespace.proyecto_final_pvalverde.repositories.IEmpleadoProyectoRepository;
import com.futurespace.proyecto_final_pvalverde.repositories.IEmpleadoRepository;
import com.futurespace.proyecto_final_pvalverde.repositories.IProyectoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpleadoProyectoService {
    //Conexión con el repositorio
    @Autowired
    private IEmpleadoProyectoRepository iEmpleadoProyectoRepository;

    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;

    @Autowired
    private IProyectoRepository iProyectoRepository;

    public ResponseEntity<List<EmpleadoProyecto>> getEmpleadoProyecto(){
        ResponseEntity<?> resp = null;
        List<EmpleadoProyecto> ep = iEmpleadoProyectoRepository.findAll();
        if(ep.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ep, HttpStatus.OK);
    }


    //Asignar Empleado a Proyecto
   /*@Transactional
    public ResponseEntity<EmpleadoProyecto> asignarEmpleadoAProyecto(Integer idEmpleado, Integer idProyecto) {
        EmpleadoProyectoId empleadoProyectoId = new EmpleadoProyectoId();
        Empleado empleado = iEmpleadoRepository.findActiveEmpleadoByIdEmpleado(idEmpleado);
        Proyecto proyecto = iProyectoRepository.findActiveProyectoByIdProyecto(idProyecto);

        LocalDate fecha_alta = LocalDate.now();

        empleadoProyectoId.setIdEmpleado(idEmpleado);
        empleadoProyectoId.setIdProyecto(idProyecto);

        EmpleadoProyecto empleadoProyecto = new EmpleadoProyecto(empleadoProyectoId, empleado, proyecto, fecha_alta);

        EmpleadoProyecto emplproy = iEmpleadoProyectoRepository.save(empleadoProyecto);

        return new ResponseEntity<>(emplproy, HttpStatus.OK);

    }*/


   /* public ResponseEntity<EmpleadoProyecto> insertEmployeeProject(@RequestBody EmpleadoProyectoId empleadoProyectoId){
        EmpleadoProyecto empleadoProyecto = new EmpleadoProyecto();
        empleadoProyecto = iEmpleadoProyectoRepository.save(empleadoProyecto);
        LocalDate fecha = LocalDate.now();
        try{
            empleadoProyecto.setFechaAlta(fecha);
            return new ResponseEntity<>(iEmpleadoProyectoRepository.save(empleadoProyecto), HttpStatus.OK);
        }catch(Exception e){
            System.out.print(e.getMessage());
            return new ResponseEntity<>(iEmpleadoProyectoRepository.save(empleadoProyecto), HttpStatus.BAD_REQUEST);
        }
    }*/

}
