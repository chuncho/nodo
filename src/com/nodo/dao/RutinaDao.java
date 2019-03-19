package com.nodo.dao;

import com.nodo.Main;
import com.nodo.model.Alumno;
import com.nodo.model.Rutina;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.Date;
import java.util.List;

public class RutinaDao {

    private static Datastore ds = Main.getDs();

    public List<Rutina> GetList() {

        Query<Rutina> q = ds.createQuery(Rutina.class).
                field("enabled").equal(true);
        List<Rutina> a = q.asList();

        return a;
    }

    public List<Rutina> GetByProfesor(Rutina profesor) {

        Query<Rutina> q = ds.createQuery(Rutina.class).
                field("profesor").equal(profesor).
                field("enabled").equal(true);
        List<Rutina> a = q.asList();

        return a;

    }

    public List<Rutina> GetByAlumno(Alumno alumno) {

        Query<Rutina> q = ds.createQuery(Rutina.class).
                field("alumno").equal(alumno);
        List<Rutina> a = q.asList();

        return a;

    }

    public Rutina GetActiveByAlumno(Alumno alumno) {

        Query<Rutina> q = ds.createQuery(Rutina.class).
                field("alumno").equal(alumno).
                field("enabled").equal(true);
        Rutina a = q.get();

        return a;

    }

    public List<Rutina> GetVencidas() {

        Date date = new Date();

        Query<Rutina> q = ds.createQuery(Rutina.class).
                field("vencimiento").lessThanOrEq(date).
                field("enabled").equal(true);
        List<Rutina> a = q.asList();

        return a;

    }

    public String Insert(Rutina a) {
        // TODO DESACTIVAR TODAS LAS DEMAS
        a.prePersist();
        Key<Rutina> id = ds.save(a);
        return id.getId().toString();
    }

    public Boolean Update(Rutina a) {

        Query<Rutina> updQuery = ds.createQuery(Rutina.class).filter("id =", a.getId());

        UpdateOperations<Rutina> updOp = ds.createUpdateOperations(Rutina.class).
                set("alumno", a.getAlumno()).
                set("profesor", a.getProfesor()).
                set("vencimiento", a.getVencimiento()).
                set("ejercicios", a.getEjercicios()).
                set("enabled", a.isEnabled());

        UpdateResults ur = ds.update(updQuery, updOp);
        return ur.getUpdatedExisting();

    }

}
