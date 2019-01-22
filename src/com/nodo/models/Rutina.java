package com.nodo.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Map;

@Entity("rutinas")
public class Rutina {

    public Rutina(){ super(); }

    @Id
    private ObjectId id;

    @Reference(idOnly = true)
    private Alumno alumno;

    @Reference(idOnly = true)
    private Profesor profesor;

    private String vencimiento;

    private Map<String,Object> ejercicios;

    private Boolean enabled;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
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
