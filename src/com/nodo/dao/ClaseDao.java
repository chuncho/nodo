package com.nodo.dao;

import com.nodo.models.Clase;
import com.nodo.models.Profesor;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class ClaseDao extends DataBase {

    public List<Clase> GetList() {

        Query<Clase> q = ds.createQuery(Clase.class).
                field("enabled").equal(true);
        List<Clase> a = q.asList();

        return a;
    }

    public List<Clase> GetByProfesor(Profesor profesor) {

        Query<Clase> q = ds.createQuery(Clase.class).
                field("profesor").equal(profesor).
                field("enabled").equal(true);
        List<Clase> a = q.asList();

        return a;

    }

    public String Insert(Clase a) {
        a.setEnabled(true);
        Key<Clase> id = ds.save(a);
        return id.getId().toString();
    }

    public Boolean Update(Clase a) {

        Query<Clase> updQuery = ds.createQuery(Clase.class).filter("id =", a.getId());

        UpdateOperations<Clase> updOp = ds.createUpdateOperations(Clase.class).
                set("nombre", a.getNombre()).
                set("tipo", a.getTipo()).
                set("monto", a.getMonto()).
                set("enabled", a.isEnabled());

        UpdateResults ur = ds.update(updQuery, updOp);
        return ur.getUpdatedExisting();

    }
}
