package com.futurespace.proyecto_final_pvalverde.repositories;

import com.futurespace.proyecto_final_pvalverde.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadosRepositorio extends JpaRepository<Empleado, Integer> {



}
