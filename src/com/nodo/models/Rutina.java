package com.nodo.models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Map;

@Entity("rutinas")
public class Rutina {

    public Rutina(){ super(); }

    @Id
    private String id;

    @Reference("id_alumno")
    private String idAlumno;

    @Reference("id_profesor")
    private String idProfesor;

    private String vencimiento;

    private Map<String,Object> ejercicios;

    private Boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
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
