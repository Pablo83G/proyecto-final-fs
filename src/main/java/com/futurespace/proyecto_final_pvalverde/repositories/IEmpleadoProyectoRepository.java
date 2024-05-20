package com.futurespace.proyecto_final_pvalverde.repositories;

import com.futurespace.proyecto_final_pvalverde.entities.EmpleadoProyecto;
import com.futurespace.proyecto_final_pvalverde.entities.EmpleadoProyectoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmpleadoProyectoRepository extends JpaRepository <EmpleadoProyecto, EmpleadoProyectoId>{
/*
    // Devuelve una lista de EmpleadoProyecto para un proyecto específico.
    List<EmpleadoProyecto> findByProyectoId(Integer id_proyecto);

    //Busca una relación específica entre un proyecto y un empleado.
    Optional<EmpleadoProyecto> findByProyectoIdAndEmpleadoId(Integer id_proyecto, Integer id_empleado);

    //obtener todos los EmpleadoProyecto donde el proyecto tiene un ID específico y el empleado no ha sido dado de baja
    @Query("SELECT ep FROM EmpleadoProyecto ep WHERE ep.id_proyecto = :id_proyecto AND ep.empleado.fecha_baja IS NULL")
    List<EmpleadoProyecto> findActiveEmpleadosByProyectoId(@Param("id_proyecto") Integer id_proyecto);

 */
}

