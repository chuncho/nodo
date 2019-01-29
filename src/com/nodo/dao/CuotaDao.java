package com.nodo.dao;

import com.nodo.models.Alumno;
import com.nodo.models.Cuota;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class CuotaDao extends DataBase {

    public List<Cuota> GetList(){

        Query<Cuota> q = ds.createQuery(Cuota.class).
                field("enabled").equal(true);
        List<Cuota> a = q.asList();

        return a;
    }

    public List<Cuota> GetByAlumno(Alumno alumno) {

        Query<Cuota> q = ds.createQuery(Cuota.class).
                field("alumno").equal(alumno).
                field("enabled").equal(true);
        List<Cuota> a = q.asList();

        return a;

    }

    public List<Cuota> GetByImpagasPorAlumno(Alumno alumno) {

        float monto = 0;

        Query<Cuota> q = ds.createQuery(Cuota.class).
                field("alumno").equal(alumno).
                field("monto_pago").equal(monto).
                field("enabled").equal(true);
        List<Cuota> a = q.asList();

        return a;

    }

    public List<Cuota> GetImpagas() {

        float monto = 0;

        Query<Cuota> q = ds.createQuery(Cuota.class).
                field("monto_pago").equal(monto).
                field("enabled").equal(true);
        List<Cuota> a = q.asList();

        return a;

    }

    public String Insert(Cuota a){
        a.setEnabled(true);
        Key<Cuota> id = ds.save(a);
        return id.getId().toString();
    }

    public Boolean Update(Cuota a){

        Query<Cuota> updQuery = ds.createQuery(Cuota.class).filter("id =", a.getId());

        UpdateOperations<Cuota> updOp = ds.createUpdateOperations(Cuota.class).
                set("monto", a.getMonto()).
                set("vencimiento", a.getVencimiento()).
                set("monto_pago", a.getMontoPago()).
                set("enabled", a.isEnabled()).
                set("fecha_pago", a.getFechaPago());

        UpdateResults ur = ds.update(updQuery, updOp);
        return ur.getUpdatedExisting();

    }

}
