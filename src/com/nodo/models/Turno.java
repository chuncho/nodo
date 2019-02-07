package com.nodo.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;

@Entity("turnos")
public class Turno {

    public Turno() {
        super();
    }

    @Id
    private ObjectId id;

    private ArrayList<String> hora;

    private ArrayList<String> dia;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ArrayList<String> getHora() {
        return hora;
    }

    public void setHora(ArrayList<String> hora) {
        this.hora = hora;
    }

    public ArrayList<String> getDia() {
        return dia;
    }

    public void setDia(ArrayList<String> dia) {
        this.dia = dia;
    }
}
