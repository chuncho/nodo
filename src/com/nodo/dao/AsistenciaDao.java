package com.nodo.dao;

import com.nodo.Main;
import com.nodo.model.Alumno;
import com.nodo.model.Asistencia;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;

import java.util.Date;
import java.util.List;

public class AsistenciaDao {

    private static Datastore ds = Main.getDs();

    public List<Asistencia> GetList() {

        Query<Asistencia> q = ds.createQuery(Asistencia.class);
        List<Asistencia> a = q.asList();

        return a;
    }

    public List<Asistencia> GetByAlumnos(Alumno alumno) {

        Query<Asistencia> q = ds.createQuery(Asistencia.class).
                field("alumno").equal(alumno);
        List<Asistencia> a = q.asList();

        return a;

    }

    public List<Asistencia> GetByFecha(Date desde, Date hasta) {

        Query<Asistencia> q = ds.createQuery(Asistencia.class).
                field("fecha").lessThanOrEq(hasta).
                field("fecha").greaterThanOrEq(desde);
        List<Asistencia> a = q.asList();

        return a;

    }

    public List<Asistencia> GetByFechaDesde(Date desde, Alumno alumno) {

        Query<Asistencia> q = ds.createQuery(Asistencia.class).
                field("fecha").greaterThanOrEq(desde).
                field("alumno").equal(alumno);
        List<Asistencia> a = q.asList();

        return a;
    }

    public String Insert(Asistencia a) {
        a.prePersist();
        Key<Asistencia> id = ds.save(a);
        return id.getId().toString();
    }
}
