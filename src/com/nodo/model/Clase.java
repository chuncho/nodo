package com.nodo.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity("clases")
public class Clase {

    public Clase() {
        super();
    }

    @Id
    private ObjectId id;

    private String nombre;

    private Float monto;

    private String tipo;

    private Boolean enabled;

    @Reference(idOnly = true)
    private Profesor profesor;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
