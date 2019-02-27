package com.nodo.dao;

import com.nodo.Main;
import com.nodo.model.Concepto;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class ConceptoDao {

    private static Datastore ds = Main.getDs();

    public List<Concepto> GetList() {

        Query<Concepto> q = ds.createQuery(Concepto.class).
                field("enabled").equal(true);
        List<Concepto> a = q.asList();

        return a;
    }

    public Concepto GetByTipo(int tipo) {
        Query<Concepto> q = ds.createQuery(Concepto.class).
                filter("tipo =", tipo).
                field("enabled").equal(true);

        Concepto a = q.get();
        return a;
    }

    public String Insert(Concepto a) {
        a.setEnabled(true);
        Key<Concepto> id = ds.save(a);
        return id.getId().toString();
    }

    public Boolean Update(Concepto a) {

        Query<Concepto> updQuery = ds.createQuery(Concepto.class).filter("id =", a.getId());

        UpdateOperations<Concepto> updOp = ds.createUpdateOperations(Concepto.class).
                set("nombre", a.getNombre()).
                set("tipo", a.getTipo()).
                set("enabled", a.isEnabled());

        UpdateResults ur = ds.update(updQuery, updOp);
        return ur.getUpdatedExisting();

    }
}
