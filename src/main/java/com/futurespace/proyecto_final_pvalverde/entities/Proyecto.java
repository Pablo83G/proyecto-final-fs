package com.futurespace.proyecto_final_pvalverde.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "PR_PROYECTOS")
public class Proyecto {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE,
            generator = "proyecto_sequence"
    )
    @SequenceGenerator(
            name = "proyecto_sequence",
            sequenceName = "proyecto_sequence",
            allocationSize = 1
    )
    @Column(
            name = "ID_PROYECTO",
            updatable = false,
            nullable = false
    )
    private Integer idProyecto;

    @Column(
            name="TX_DESCRIPCIÓN",
            length = 125,
            nullable=false,
            columnDefinition = "TEXT"
    )
    @NotBlank(message = "Este campo no puede estar vacío")
    @Size(message = "Este campo debe tener un máximo de 125 caracteres")
    private String descripcion;

    @Column(
            name="F_INICIO",
            nullable=false,
            columnDefinition = "DATE"
    )
    @NotNull(message = "Este campo no puede estar vacío")
    private LocalDate fecha_inicio;

    @Column(
            name="F_FIN",
            columnDefinition = "DATE"
    )
    private LocalDate fecha_fin;

    @Column(
            name="F_BAJA",
            columnDefinition = "DATE"
    )
    private LocalDate fecha_baja;

    @Column(
            name="TX_LUGAR",
            length = 30,
            columnDefinition = "TEXT"
    )
    @Size(max = 30, message = "Este campo no puede tener más de 30 caracteres")
    private String lugar;

    @Column(
            name="TX_OBSERVACIONES",
            length = 300,
            columnDefinition = "TEXT"
    )
    @Size(max = 300, message = "Este campo no puede tener más de 300 caracteres")
    private String observaciones;



    //CONSTRUCTOR
    public Proyecto() {
    }

    public Proyecto(String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin,
                    LocalDate fecha_baja, String lugar, String observaciones) {
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_baja = fecha_baja;
        this.lugar = lugar;
        this.observaciones = observaciones;
    }

    public Proyecto(Integer idProyecto, String descripcion, LocalDate fecha_inicio,
                    LocalDate fecha_fin, LocalDate fecha_baja, String lugar,
                    String observaciones) {
        this.idProyecto = idProyecto;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_baja = fecha_baja;
        this.lugar = lugar;
        this.observaciones = observaciones;
    }


    //GETTER AND SETTER
    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public LocalDate getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(LocalDate fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


}

