package com.nodo.dao;

import com.nodo.model.Plantilla;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class PlantillaDao extends DataBase {

    public List<Plantilla> GetList() {

        Query<Plantilla> q = ds.createQuery(Plantilla.class).
                field("enabled").equal(true);
        List<Plantilla> a = q.asList();

        return a;
    }

    public String Insert(Plantilla a) {
        a.setEnabled(true);
        Key<Plantilla> id = ds.save(a);
        return id.getId().toString();
    }

    public Boolean Update(Plantilla a) {

        Query<Plantilla> updQuery = ds.createQuery(Plantilla.class).filter("id =", a.getId());

        UpdateOperations<Plantilla> updOp = ds.createUpdateOperations(Plantilla.class).
                set("nombre", a.getNombre()).
                set("ejercicios", a.getEjercicios()).
                set("enabled", a.isEnabled());

        UpdateResults ur = ds.update(updQuery, updOp);
        return ur.getUpdatedExisting();

    }

}
