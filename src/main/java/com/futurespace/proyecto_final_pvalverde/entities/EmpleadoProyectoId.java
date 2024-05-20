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

    public EmpleadoProyectoId() {
    }

    public EmpleadoProyectoId(Integer idEmpleado, Integer idProyecto) {
        this.idEmpleado = idEmpleado;
        this.idProyecto = idProyecto;
    }

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
/* @Column
    private Integer id_empleado;
    @Column
    private Integer id_proyecto;

    //CONSTRUCTORES
    public EmpleadoProyectoId() {
    }

    public EmpleadoProyectoId(Integer id_empleado, Integer id_proyecto) {
        this.id_empleado = id_empleado;
        this.id_proyecto = id_proyecto;
    }

    //GETTER AND SETTER

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Integer getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }*/
}
