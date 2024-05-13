package com.futurespace.proyecto_final_pvalverde.services;

import com.futurespace.proyecto_final_pvalverde.repositories.IEmpleadosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    //Conecta con el repositorio con el Autowired
    @Autowired
    private IEmpleadosRepositorio iEmpleadosRepositorio;

    //CONSTRUCTOR
    public EmpleadoService() {}



}
