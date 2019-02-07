package com.nodo.dao;

import com.nodo.models.Auditoria;
import com.nodo.models.Profesor;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;

import java.util.Date;
import java.util.List;

public class AuditoriaDao extends DataBase {

    public List<Auditoria> GetList() {

        Query<Auditoria> q = ds.createQuery(Auditoria.class);
        List<Auditoria> a = q.asList();

        return a;
    }

    public List<Auditoria> GetByProfesor(Profesor profesor) {

        Query<Auditoria> q = ds.createQuery(Auditoria.class).
                field("profesor").equal(profesor);
        List<Auditoria> a = q.asList();

        return a;

    }

    public List<Auditoria> GetByFecha(Date desde, Date hasta) {

        Query<Auditoria> q = ds.createQuery(Auditoria.class).
                field("fecha").lessThanOrEq(hasta).
                field("fecha").greaterThanOrEq(desde);
        List<Auditoria> a = q.asList();

        return a;

    }

    public List<Auditoria> GetByFechaYProfesor(Date desde, Date hasta, Profesor profesor) {

        Query<Auditoria> q = ds.createQuery(Auditoria.class).
                field("fecha").lessThanOrEq(hasta).
                field("fecha").greaterThanOrEq(desde).
                field("profesor").equal(profesor);
        List<Auditoria> a = q.asList();

        return a;

    }

    public String Insert(Auditoria a) {
        a.prePersist();
        Key<Auditoria> id = ds.save(a);
        return id.getId().toString();
    }

}
