package com.nodo.models;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "profesores")
public class Profesor {

    @Id
    @Type(type = "objectid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profesor() {
        super();
    }

    private int dni;
    private String nombre;
    private Long telefono;
    private String user;
    private String pass;
    private String fecha_creacion;
    private String ultima_modificacion;
    private String ingreso;
    private String egreso;
    private boolean enabled;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFechaCreacion() {
        return fecha_creacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fecha_creacion = fechaCreacion;
    }

    public String getUltimaModificacion() {
        return ultima_modificacion;
    }

    public void setUltimaModificacion(String ultimaModificacion) {
        this.ultima_modificacion = ultimaModificacion;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEgreso() {
        return egreso;
    }

    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
