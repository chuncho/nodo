package com.nodo.models;

import org.mongodb.morphia.annotations.*;
import org.bson.types.ObjectId;

import java.util.Map;

@Entity("alumnos")
public class Alumno {

    public Alumno() {
        super();
    }

    @Id
    private ObjectId id;

    private int dni;

    private String nombre;

    private Long telefono;

    @Property("telefono_contacto")
    private Long telefonoContacto;

    @Reference(idOnly = true)
    private Clase clase;

    @Reference(idOnly = true)
    private Turno turno;

    @Property("fecha_creacion")
    private String fechaCreacion;

    @Property("ultima_modificacion")
    private String ultimaModificacion;

    private String estado;

    private Boolean enabled;

    @Property("datos_adicionales")
    private Map<String,String> datosAdicionales;

    // getters and setters

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public Clase getClase() {
        return clase;
    }

    public Turno getTurno() {
        return turno;
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

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
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
        return datosAdicionales;
    }

    public void setDatosAdicionales(Map<String, String> datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }

}