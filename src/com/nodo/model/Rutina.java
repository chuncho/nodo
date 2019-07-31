package com.nodo.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Entity("rutinas")
public class Rutina {

    public Rutina() {
        super();
    }

    @Id
    private ObjectId id;

    @Reference(idOnly = true)
    private Alumno alumno;

    @Reference(idOnly = true)
    private Profesor profesor;

    private Date vencimiento;

    private Map<String, ArrayList<String>> ejercicios;

    private Boolean enabled;

    public void prePersist() {
        this.enabled = true;
    }

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

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Map<String, ArrayList<String>> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(Map<String, ArrayList<String>> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
