package com.futurespace.proyecto_final_pvalverde.services;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.repositories.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Empleado> listaEmplFechaBajaIsNull = new ArrayList<>();

        for(Empleado empl : emplList){
            if(empl.getFecha_baja() == null){
                listaEmplFechaBajaIsNull.add(empl);
            }

        }
        return new ResponseEntity<>(listaEmplFechaBajaIsNull, HttpStatus.OK);

    }


   public ResponseEntity<Object> getByIdEmpleado(Integer idEmpleado){
       ResponseEntity<Object> resp = null;
       if(idEmpleado == null){
           return ResponseEntity.badRequest().body("ID de empleado no proporcionado");
       }
       Optional<Empleado> empl = iEmpleadoRepository.findById(idEmpleado);
       if(empl.isEmpty()){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(empl);
   }


    //Borrar datos
    public ResponseEntity<Object> deleteIdEmpleado(int idEmpleado){
        ResponseEntity<Object> resp = null;
        //Optional<Empleado> empleadoId = iEmpleadosRepositorio.findById(idEmpleado);
        iEmpleadoRepository.deleteById(idEmpleado);
        resp = new ResponseEntity<>("Empleado eliminado correctamente", HttpStatus.OK);
        return resp;
    }


    //Actualizar Fecha de Baja Empleado
   public ResponseEntity<Object> updateFechaBajaEmpleado(int idEmpleado) {
        try {
            Optional<Empleado> optionalEmpleado = iEmpleadoRepository.findById(idEmpleado);
            if (optionalEmpleado.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Empleado empleado = optionalEmpleado.get();
            if (empleado.getFecha_baja() != null) {
                return ResponseEntity.badRequest().body("El empleado ya ha sido dado de baja anteriormente");
            }

            // Verificar si el empleado está asignado a proyectos
            /*if (!empleado.getProyecto().isEmpty()) {
                StringBuilder mensaje = new StringBuilder("No se puede dar de baja al empleado ");
                mensaje.append(empleado.getNombre_completo());
                mensaje.append(" porque está asignado al/los proyecto/s: ");
                mensaje.append(empleado.getProyecto().stream().map(Proyecto::getDescripcion).collect(Collectors.joining(", ")));
                return ResponseEntity.badRequest().body(mensaje.toString());
            }*/

            empleado.setFecha_baja(LocalDate.now());
            iEmpleadoRepository.save(empleado);

            return ResponseEntity.ok("Empleado dado de baja correctamente");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Ha ocurrido un error al dar de baja al empleado");
        }
    }



}
