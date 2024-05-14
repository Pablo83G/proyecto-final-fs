package com.futurespace.proyecto_final_pvalverde.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "proyectos")
@Table(name = "PR_PROYECTOS")
public class Proyecto {
    /*/ID_PROYECTO 				INT(5) PRIMARY KEY NOT NULL */
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "proyecto_seq"
    )
    @SequenceGenerator(
            name = "proyecto_seq",
            sequenceName = "proyecto_sequence",
            allocationSize = 1
    )
    @Column(
            name = "ID_PROYECTO",
            updatable = false,
            nullable = false
    )
    private int id_proyecto;

    @Column(
            name="TX_DESCRIPCIÓN",
            length = 125,
            nullable=false,
            columnDefinition = "TEXT"
    )
    private String descripcion;

    @Column(
            name="F_INICIO",
            nullable=false,
            columnDefinition = "DATE"
    )
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
    private String lugar;

    @Column(
            name="TX_OBSERVACIONES",
            length = 300,
            columnDefinition = "TEXT"
    )
    private String observaciones;

    //CONSTRUCTOR
    public Proyecto() {
    }

    public Proyecto(int id_proyecto, String descripcion, LocalDate fecha_inicio,
                    LocalDate fecha_fin, LocalDate fecha_baja, String lugar,
                    String observaciones) {
        this.id_proyecto = id_proyecto;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_baja = fecha_baja;
        this.lugar = lugar;
        this.observaciones = observaciones;
    }

    //GETTER AND SETTER

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
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
