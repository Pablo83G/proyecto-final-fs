package com.futurespace.proyecto_final_pvalverde.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EmpleadoProyectoId implements Serializable {


    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "id_proyecto")
    private Integer idProyecto;

    //CONSTRUCTORES
    public EmpleadoProyectoId() {
    }

    public EmpleadoProyectoId(Integer idEmpleado, Integer idProyecto) {
        this.idEmpleado = idEmpleado;
        this.idProyecto = idProyecto;
    }

    //GETTER AND SETTER

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
}
