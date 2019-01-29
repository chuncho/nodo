package com.nodo.dao;

import com.nodo.models.Configuracion;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class ConfiguracionDao extends DataBase {

    public List<Configuracion> GetList(){

        Query<Configuracion> q = ds.createQuery(Configuracion.class).
                field("enabled").equal(true);
        List<Configuracion> a = q.asList();

        return a;
    }

    public String Insert(Configuracion a){
        a.setEnabled(true);
        Key<Configuracion> id = ds.save(a);
        return id.getId().toString();
    }

    public Boolean Update(Configuracion a){

        Query<Configuracion> updQuery = ds.createQuery(Configuracion.class).filter("id =", a.getId());

        UpdateOperations<Configuracion> updOp = ds.createUpdateOperations(Configuracion.class).
                set("nombre", a.getNombre()).
                set("data", a.getData()).
                set("enabled", a.isEnabled());

        UpdateResults ur = ds.update(updQuery, updOp);
        return ur.getUpdatedExisting();

    }
}
