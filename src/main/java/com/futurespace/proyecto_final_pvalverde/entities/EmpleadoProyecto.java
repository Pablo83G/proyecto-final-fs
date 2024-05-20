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
        private Empleado idEmpleado;

        @ManyToOne
        //@MapsId("id_proyecto")
        @JoinColumn(name = "ID_PROYECTO")
        private Proyecto idProyecto;

        @Column(name = "F_ALTA", nullable = false)
        private LocalDate fechaAlta;

        //CONSTRUCTORES
        public EmpleadoProyecto() {
        }

        public EmpleadoProyecto(EmpleadoProyectoId id, Empleado idEmpleado, Proyecto idProyecto, LocalDate fechaAlta) {
                this.id = id;
                this.idEmpleado = idEmpleado;
                this.idProyecto = idProyecto;
                this.fechaAlta = fechaAlta;
        }

//GETTER AND SETTER

        public EmpleadoProyectoId getId() {
                return id;
        }

        public void setId(EmpleadoProyectoId id) {
                this.id = id;
        }

        public Empleado getIdEmpleado() {
                return idEmpleado;
        }

        public void setIdEmpleado(Empleado idEmpleado) {
                this.idEmpleado = idEmpleado;
        }

        public Proyecto getIdProyecto() {
                return idProyecto;
        }

        public void setIdProyecto(Proyecto idProyecto) {
                this.idProyecto = idProyecto;
        }

        public LocalDate getFechaAlta() {
                return fechaAlta;
        }

        public void setFechaAlta(LocalDate fechaAlta) {
                this.fechaAlta = fechaAlta;
        }
}
