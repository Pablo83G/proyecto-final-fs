package com.futurespace.proyecto_final_pvalverde.services;

import com.futurespace.proyecto_final_pvalverde.repositories.IEmpleadoProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoProyectoService {

    @Autowired
    private IEmpleadoProyectoRepository iEmpleadoProyectoRepository;



}
