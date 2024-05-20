package com.futurespace.proyecto_final_pvalverde.repositories;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
//Nombre de clase y tipo de datos de su ID
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query("SELECT e FROM EM_EMPLEADOS e WHERE e.idEmpleado = ?1 AND e.fecha_baja IS NULL")
    Empleado findActiveEmpleadoByIdEmpleado(Integer idEmpleado);
}
