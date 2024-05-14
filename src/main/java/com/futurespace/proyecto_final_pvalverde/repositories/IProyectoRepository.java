package com.futurespace.proyecto_final_pvalverde.repositories;

import com.futurespace.proyecto_final_pvalverde.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {

}
