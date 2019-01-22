package com.nodo.models;


import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Map;

@Entity("plantillas")
public class Plantilla {

    public Plantilla() { super(); }

    @Id
    private String id;

    private String nombre;

    private Map<String,Object> ejercicios;

    private Boolean enabled;

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

    public Map<String, Object> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(Map<String, Object> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
