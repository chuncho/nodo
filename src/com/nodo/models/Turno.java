package com.nodo.models;


import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "turnos")
public class Turno {

    public Turno() {
        super();
    }

    @Id
    @Type(type = "objectid")
    private String id;
    private Object hora;
    private Object dia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getHora() {
        return hora;
    }

    public void setHora(Object hora) {
        this.hora = hora;
    }

    public Object getDia() {
        return dia;
    }

    public void setDia(Object dia) {
        this.dia = dia;
    }



}
