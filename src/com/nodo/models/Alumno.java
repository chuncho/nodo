package com.nodo.models;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import java.util.List;

@Entity(name = "alumnos")
public class Alumno {

    @Id
    @Type(type = "objectid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Alumno() {
        super();
    }

    private int dni;
    private String nombre;
    private Long telefono;
    private Long telefono_contacto;
    private String id_clase;
    private String id_turno;
    private String fecha_creacion;
    private String ultima_modificacion;
    private String estado;
    private Boolean enabled;
    //private Object datosAdicionales;


    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public Long getTelefonoContacto() {
        return telefono_contacto;
    }

    public String getIdClase() {
        return id_clase;
    }

    public String getIdTurno() {
        return id_turno;
    }

    public String getFechaCreacion() {
        return fecha_creacion;
    }

    public String getUltimaModificacion() {
        return ultima_modificacion;
    }

    public String getEstado() {
        return estado;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public void setTelefonoContacto(Long telefonoContacto) {
        this.telefono_contacto = telefonoContacto;
    }

    public void setIdClase(String idClase) {
        this.id_clase = idClase;
    }

    public void setIdTurno(String idTurno) {
        this.id_turno = idTurno;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fecha_creacion = fechaCreacion;
    }

    public void setUltimaModificacion(String ultimaModificacion) {
        this.ultima_modificacion = ultimaModificacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /*public Object getDatosAdicionales() {

        return datosAdicionales;
    }

    public void setDatosAdicionales(Object datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }*/

}