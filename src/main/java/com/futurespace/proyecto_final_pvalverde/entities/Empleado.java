package com.futurespace.proyecto_final_pvalverde.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    @GeneratedValue( strategy = GenerationType.SEQUENCE,
            generator = "empleado_sequence"
    )
    @SequenceGenerator(
            name = "empleado_sequence",
            sequenceName = "empleado_sequence",
            allocationSize = 1
    )
    @Column(
            name = "ID_EMPLEADO",
            updatable = false,
            nullable = false
    )
    private Integer id_empleado;

    @Column(name = "TX_NIF",
            length = 9,
            columnDefinition = "TEXT",
            nullable = false)
    @Size(min = 9, max = 9, message = "El NIF debe tener 9 caracteres")
    private String nif;

    @Column(name = "TX_NOMBRE",
            length = 30,
            columnDefinition = "TEXT",
            nullable = false)
    @Size(max = 30, message = "El campo nombre no puede tener más de 30 caracteres")
    @NotBlank(message = "Este campo no puede quedar vacío")
    private String nombre;

    @Column(name = "TX_APELLIDO1",
            length = 40,
            columnDefinition = "TEXT",
            nullable = false)
    @Size(max = 40, message = "Este campo no puede tener más de 40 caracteres")
    @NotBlank(message = "Este campo no puede quedar vacío")
    private String primer_apellido;

    @Column(name = "TX_APELLIDO2",
            length = 40,
            columnDefinition = "TEXT",
            nullable = false
    )
    @Size(max = 40, message = "Este campo no puede tener más de 40 caracteres")
    @NotBlank(message = "Este campo no puede quedar vacío")
    private String segundo_apellido;

    @Column(name = "N_TELEFONO1",
            length = 12,
            columnDefinition = "TEXT",
            nullable = false)
    @NotBlank(message = "El campo primer teléfono no puede estar vacío")
    @Size(min = 9, max = 12, message = "El campo primer teléfono debe tener un un mínimo de 9 y máximo de 12 caracteres")
    private String telefono_uno;

    @Column(
            name = "N_TELEFONO2",
            length = 12,
            columnDefinition = "TEXT",
            nullable = false)
    @NotBlank(message = "El campo segundo teléfono no puede estar vacío")
    @Size(min = 9, max = 12, message = "El campo campo segundo teléfono debe tener un un mínimo de 9 y máximo de 12 caracteres")

    private String telefono_dos;

    @Column(
            name = "F_NACIMIENTO",
            nullable = false,
            columnDefinition = "DATE"
    )
    @NotNull(message = "Este campo se debe rellenar de forma obligatoria")
    private LocalDate fecha_nacimiento;

    @Column(
            name="F_ALTA",
            nullable=false,
            columnDefinition="DATE"
    )
    @NotNull(message = "Este campo no puede estar vacío")
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
    @Email(message = "Introduce una dirección de mail correcta")
    @NotBlank(message = "El campo Email no puede estar vacío")
    @Size(max = 40, message = "El campo Email debe tener un máximo de 40 caracteres")
    private String email;

    @Column(
            name="CX_EDOCIVIL",
            nullable=false,
            length = 1,
            columnDefinition = "CHAR"
    )
    @NotNull(message = "Esta campo no puede estar vacío")
    private Character estado_civil;

    @Column(
            name="B_SERVMILITAR",
            nullable = false,
            length = 1,
            columnDefinition = "CHAR"
    )
    @NotNull(message = "Esta campo no puede estar vacío")
    private Character servicio_militar;


    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<EmpleadoProyecto> empleadoProyecto = new HashSet<>();


//CONSTRUCTORES

    public Empleado() {
    }

    public Empleado(Integer id_empleado, String nif, String nombre, String primer_apellido,
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


    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
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

    public Character getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(Character estado_civil) {
        this.estado_civil = estado_civil;
    }

    public Character getServicio_militar() {
        return servicio_militar;
    }

    public void setServicio_militar(Character servicio_militar) {
        this.servicio_militar = servicio_militar;
    }

    public Set<EmpleadoProyecto> getEmpleadoProyecto() {
        return empleadoProyecto;
    }

    public void setEmpleadoProyecto(Set<EmpleadoProyecto> empleadoProyecto) {
        this.empleadoProyecto = empleadoProyecto;
    }
}
