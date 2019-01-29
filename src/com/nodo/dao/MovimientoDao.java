package com.nodo.dao;

import com.nodo.models.Concepto;
import com.nodo.models.Movimiento;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;

import java.util.Date;
import java.util.List;

public class MovimientoDao extends DataBase {

    public List<Movimiento> GetList(){

        Query<Movimiento> q = ds.createQuery(Movimiento.class);
        List<Movimiento> a = q.asList();

        return a;
    }

    public List<Movimiento> GetByFecha(Date desde, Date hasta) {

        Query<Movimiento> q = ds.createQuery(Movimiento.class).
                field("fecha").lessThanOrEq(hasta).
                field("fecha").greaterThanOrEq(desde);
        List<Movimiento> a = q.asList();

        return a;

    }

    public List<Movimiento> GetByConcepto(Concepto concepto) {

        Query<Movimiento> q = ds.createQuery(Movimiento.class).
                field("concepto").equal(concepto);
        List<Movimiento> a = q.asList();

        return a;

    }

    public List<Movimiento> GetByFechaYConcepto(Date desde, Date hasta, Concepto concepto) {

        Query<Movimiento> q = ds.createQuery(Movimiento.class).
                field("fecha").lessThanOrEq(hasta).
                field("fecha").greaterThanOrEq(desde).
                field("concepto").equal(concepto);;
        List<Movimiento> a = q.asList();

        return a;

    }

    public List<Movimiento> GetByCaja(String caja) {

        Query<Movimiento> q = ds.createQuery(Movimiento.class).
                filter("tipo_caja =", caja);
        List<Movimiento> a = q.asList();

        return a;

    }

    public String Insert(Movimiento a){
        a.prePersist();
        Key<Movimiento> id = ds.save(a);
        return id.getId().toString();
    }

}
