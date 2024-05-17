package com.futurespace.proyecto_final_pvalverde.repositories;

import com.futurespace.proyecto_final_pvalverde.entities.EmpleadoProyecto;
import com.futurespace.proyecto_final_pvalverde.entities.EmpleadoProyectoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoProyectoRepository extends JpaRepository <EmpleadoProyecto, EmpleadoProyectoId>{
}
