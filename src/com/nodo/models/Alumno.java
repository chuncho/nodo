package com.nodo.models;

import org.mongodb.morphia.annotations.*;

import java.util.Map;

@Entity("alumnos")
public class Alumno {

    public Alumno() {
        super();
    }

    @Id
    private String id;

    private int dni;

    private String nombre;

    private Long telefono;

    @Reference("telefono_contacto")
    private Long telefonoContacto;

    @Reference("id_clase")
    private String idClase;

    @Reference("id_turno")
    private String idTurno;

    @Reference("fecha_creacion")
    private String fechaCreacion;

    @Reference("ultima_modificacion")
    private String ultimaModificacion;

    private String estado;

    private Boolean enabled;

    private Map<String,String> datos_adicionales;

    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return telefonoContacto;
    }

    public String getIdClase() {
        return idClase;
    }

    public String getIdTurno() {
        return idTurno;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getUltimaModificacion() {
        return ultimaModificacion;
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
        this.telefonoContacto = telefonoContacto;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public void setIdTurno(String idTurno) {
        this.idTurno = idTurno;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setUltimaModificacion(String ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Map<String, String> getDatosAdicionales() {
        return datos_adicionales;
    }

    public void setDatosAdicionales(Map<String, String> datos_adicionales) {
        this.datos_adicionales = datos_adicionales;
    }
}