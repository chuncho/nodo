package com.nodo.dao;

import com.mongodb.MongoClient;
import com.nodo.models.Alumno;
import com.nodo.models.Turno;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.List;



public class MainDao {

    final Morphia morphia = new Morphia();
    final Datastore ds = morphia.createDatastore(new MongoClient(), "dbnodo");

    public List<Alumno> GetListAlumnos(){

        Query<Alumno> q = ds.createQuery(Alumno.class);
        List<Alumno> alumnos = q.asList();

        return alumnos;
    }

    public List<Turno> GetListTurnos(){

        Query<Turno> q = ds.createQuery(Turno.class);
        List<Turno> alumnos = q.asList();

        return alumnos;
    }
}
