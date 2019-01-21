package com.nodo.models;

import org.mongodb.morphia.annotations.*;

@Entity("clases")
public class Clase {

    public Clase() {
        super();
    }

    @Id
    private String id;

    private String nombre;

    private Float monto;

    private String tipo;

    private Boolean enabled;

    @Reference("id_profesor")
    private String idProfesor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getId_profesor() {
        return idProfesor;
    }

    public void setId_profesor(String id_profesor) {
        this.idProfesor = id_profesor;
    }
}
