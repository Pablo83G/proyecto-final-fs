package com.futurespace.proyecto_final_pvalverde.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "PR_EMPLEADO_PROYECTO")
//@Table
public class EmpleadoProyecto {

        @EmbeddedId
        private EmpleadoProyectoId id;

        @ManyToOne
        //@MapsId("id_empleado")
        @JoinColumn(name = "ID_EMPLEADO")
        private Empleado empleado;

        @ManyToOne
       // @MapsId("id_proyecto")
        @JoinColumn(name = "ID_PROYECTO")
        private Proyecto proyecto;

        @Column(name = "F_ALTA", nullable = false)
        private LocalDate fecha_alta;

        //CONSTRUCTORES
        public EmpleadoProyecto() {
        }

        public EmpleadoProyecto(EmpleadoProyectoId id, Empleado empleado, Proyecto proyecto, LocalDate fecha_alta) {
                this.id = id;
                this.empleado = empleado;
                this.proyecto = proyecto;
                this.fecha_alta = fecha_alta;
        }

//GETTER AND SETTER

        public EmpleadoProyectoId getId() {
                return id;
        }

        public void setId(EmpleadoProyectoId id) {
                this.id = id;
        }

        public Empleado getEmpleado() {
                return empleado;
        }

        public void setEmpleado(Empleado empleado) {
                this.empleado = empleado;
        }

        public Proyecto getProyecto() {
                return proyecto;
        }

        public void setProyecto(Proyecto proyecto) {
                this.proyecto = proyecto;
        }

        public LocalDate getFecha_alta() {
                return fecha_alta;
        }

        public void setFecha_alta(LocalDate fecha_alta) {
                this.fecha_alta = fecha_alta;
        }
}
