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
import java.util.Optional;

@Service
public class EmpleadoProyectoService {

    @Autowired
    private IEmpleadoProyectoRepository iEmpleadoProyectoRepository;

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Autowired
    private IProyectoRepository proyectoRepository;

    public ResponseEntity<List<EmpleadoProyecto>> getEmpleadoProyecto(){
        ResponseEntity<?> resp = null;
        List<EmpleadoProyecto> ep = iEmpleadoProyectoRepository.findAll();
        if(ep.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ep, HttpStatus.OK);
    }


    //Asignar Empleado a Proyecto
   @Transactional
    public ResponseEntity<EmpleadoProyecto> asignarEmpleadoAProyecto(Integer id_empleado, Integer id_proyecto, Empleado empleado, Proyecto proyecto, LocalDate fecha_alta) {
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(id_empleado);
        Optional<Proyecto> proyectoOpt = proyectoRepository.findById(id_proyecto);

        if (empleadoOpt.isEmpty() || proyectoOpt.isEmpty()) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        fecha_alta = LocalDate.now();
        empleado = empleadoOpt.get();
        proyecto = proyectoOpt.get();
        EmpleadoProyectoId empleadoProyectoId = new EmpleadoProyectoId(id_empleado, id_proyecto);
        EmpleadoProyecto empleadoProyecto = new EmpleadoProyecto(empleadoProyectoId, empleado, proyecto, fecha_alta);

        EmpleadoProyecto emplproy = iEmpleadoProyectoRepository.save(empleadoProyecto);

        return new ResponseEntity<>(emplproy, HttpStatus.OK);

    }


    public ResponseEntity<EmpleadoProyecto> insertEmployeeProject(@RequestBody EmpleadoProyecto empleadoProyecto){

        LocalDate fecha = LocalDate.now();
        try{
            empleadoProyecto.setFecha_alta(fecha);
            return new ResponseEntity<>(iEmpleadoProyectoRepository.save(empleadoProyecto), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(iEmpleadoProyectoRepository.save(empleadoProyecto), HttpStatus.BAD_REQUEST);
        }
    }

}
