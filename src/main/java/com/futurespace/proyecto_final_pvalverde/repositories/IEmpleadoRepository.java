package com.futurespace.proyecto_final_pvalverde.repositories;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Nombre de clase y tipo de datos de su ID
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
