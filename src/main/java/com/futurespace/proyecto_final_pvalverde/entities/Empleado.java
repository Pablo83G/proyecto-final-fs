package com.futurespace.proyecto_final_pvalverde.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

//@Entity para identificar que una clase sea una entidad
// Recibe como parametro un atributo y podemor representar el nombre
//de la entidad de nuestra clase. El nombre no es el nombre de la tabla en la bd
//si no una representación de la entidad que utilizaremos para realizar consultas
@Entity(name = "empleados")
//Nos ayuda a representar esta entidad como una tabla
@Table(name = "EM_EMPLEADOS")
public class Empleado {
    @Id
    //GenerateValue = de que manera se va a generar nuestra clave primaria
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "empleado_seq"
    )
    @SequenceGenerator(
            name = "empleado_seq",
            sequenceName = "empleado_sequence",
            allocationSize = 1
    )
    @Column(
            name = "ID_EMPLEADO",
            updatable = false,
            nullable = false
    )
    private int id_empleado;

    @Column(name = "TX_NIF",
            length = 9,
            columnDefinition = "TEXT",
            nullable = false)
    private String nif;

    @Column(name = "TX_NOMBRE",
            length = 30,
            columnDefinition = "TEXT",
            nullable = false)
    private String nombre;

    @Column(name = "TX_APELLIDO1",
            length = 40,
            columnDefinition = "TEXT",
            nullable = false)
    private String primer_apellido;

    @Column(name = "TX_APELLIDO2",
            length = 40,
            columnDefinition = "TEXT",
            nullable = false
    )
    private String segundo_apellido;

    @Column(name = "N_TELEFONO1",
            length = 12,
            columnDefinition = "TEXT",
            nullable = false)
    private String telefono_uno;

    @Column(
            name = "N_TELEFONO2",
            length = 12,
            columnDefinition = "TEXT",
            nullable = false)
    private String telefono_dos;

    @Column(
            name = "F_NACIMIENTO",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate fecha_nacimiento;

    @Column(
            name="F_ALTA",
            nullable=false,
            columnDefinition="DATE"
    )
    private LocalDate fecha_alta;

    @Column(
            name="F_BAJA",
            columnDefinition="DATE"
    )
    private LocalDate fecha_baja;
    @Column(
            name = "TX_EMAIL",
            length = 40,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name="CX_EDOCIVIL",
            nullable=false,
            columnDefinition = "CHAR"
    )
    private char estado_civil;

    @Column(
            name="B_SERVMILITAR",
            nullable = false,
            columnDefinition = "CHAR"
    )
    private char servicio_militar;

    //CONSTRUCTORES

    public Empleado() {
    }

    public Empleado(int id_empleado, String nif, String nombre, String primer_apellido,
                    String segundo_apellido, String telefono_uno, String telefono_dos,
                    LocalDate fecha_nacimiento, LocalDate fecha_alta, LocalDate fecha_baja,
                    String email, char estado_civil, char servicio_militar) {
        this.id_empleado = id_empleado;
        this.nif = nif;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.telefono_uno = telefono_uno;
        this.telefono_dos = telefono_dos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.email = email;
        this.estado_civil = estado_civil;
        this.servicio_militar = servicio_militar;
    }

    //SETTER Y GETTER

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getTelefono_uno() {
        return telefono_uno;
    }

    public void setTelefono_uno(String telefono_uno) {
        this.telefono_uno = telefono_uno;
    }

    public String getTelefono_dos() {
        return telefono_dos;
    }

    public void setTelefono_dos(String telefono_dos) {
        this.telefono_dos = telefono_dos;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public LocalDate getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(LocalDate fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public LocalDate getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(LocalDate fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(char estado_civil) {
        this.estado_civil = estado_civil;
    }

    public char getServicio_militar() {
        return servicio_militar;
    }

    public void setServicio_militar(char servicio_militar) {
        this.servicio_militar = servicio_militar;
    }


}
