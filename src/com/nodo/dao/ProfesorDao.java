package com.nodo.dao;

import com.nodo.Main;
import com.nodo.model.Profesor;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class ProfesorDao {

    private static Datastore ds = Main.getDs();

    public List<Profesor> GetList() {

        Query<Profesor> q = ds.createQuery(Profesor.class).
                field("enabled").equal(true);
        List<Profesor> profesores = q.asList();

        return profesores;
    }

    public Profesor GetByDni(int dni) {
        Query<Profesor> q = ds.createQuery(Profesor.class).
                filter("dni =", dni);

        Profesor p = q.get();
        return p;
    }

    public Profesor GetByUser(String user) {

        Query<Profesor> q = ds.createQuery(Profesor.class).
                filter("user =", user);

        Profesor p = q.get();
        return p;
    }

    public String Insert(Profesor p) {
        p.prePersist();
        p.setEnabled(true);
        Key<Profesor> id = ds.save(p);
        return id.getId().toString();
    }

    public Boolean Update(Profesor p) {

        p.prePersist();
        Query<Profesor> updQuery = ds.createQuery(Profesor.class).filter("id =", p.getId());

        UpdateOperations<Profesor> updOp = ds.createUpdateOperations(Profesor.class).
                set("nombre", p.getNombre()).
                set("telefono", p.getTelefono()).
                set("user", p.getUser()).
                set("pass", p.getUncryptedPass()).
                set("ultima_modificacion", p.getUltimaModificacion()).
                set("ingreso", p.getIngreso()).
                set("egreso", p.getEgreso()).
                set("enabled", p.isEnabled());

        UpdateResults ur = ds.update(updQuery, updOp);
        return ur.getUpdatedExisting();

    }
}
