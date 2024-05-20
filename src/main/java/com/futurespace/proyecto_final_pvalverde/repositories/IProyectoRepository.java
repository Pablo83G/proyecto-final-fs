package com.futurespace.proyecto_final_pvalverde.repositories;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import com.futurespace.proyecto_final_pvalverde.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {

  @Query("SELECT e FROM PR_PROYECTO e WHERE e.idProyecto = ?1 AND e.fecha_baja IS NULL")
    Proyecto findActiveProyectoByIdProyecto(Integer idProyecto);

}

