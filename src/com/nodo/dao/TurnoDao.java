package com.nodo.dao;

import com.nodo.Main;
import com.nodo.model.Turno;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class TurnoDao {

    private static Datastore ds = Main.getDs();

    public List<Turno> GetList() {

        Query<Turno> q = ds.createQuery(Turno.class).
                field("enabled").equal(true);
        List<Turno> a = q.asList();

        return a;
    }

    public String Insert(Turno a) {
        Key<Turno> id = ds.save(a);
        return id.getId().toString();
    }

    public Boolean Update(Turno a) {

        Query<Turno> updQuery = ds.createQuery(Turno.class).filter("id =", a.getId());

        UpdateOperations<Turno> updOp = ds.createUpdateOperations(Turno.class).
                set("dia", a.getDia()).
                set("hora", a.getHora());

        UpdateResults ur = ds.update(updQuery, updOp);
        return ur.getUpdatedExisting();

    }
}
