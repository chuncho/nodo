package com.nodo.dao;

import com.nodo.models.Alumno;
import com.nodo.models.Cuota;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.*;

public class CuotaDao extends DataBase {

    public List<Cuota> GetList() {

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

    public String Insert(Cuota a) {
        a.setEnabled(true);
        Key<Cuota> id = ds.save(a);
        return id.getId().toString();
    }

    public Boolean Update(Cuota a) {

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

    public Map<String, Object> AlertaCuotas(Alumno alumno) {
        Map<String, Object> resp = new HashMap<>();

        boolean debe = false;
        float monto = 0;
        int contador = 0;
        String mensaje;

        Date diaVencimiento = new Date();
        diaVencimiento.setDate(10);
        diaVencimiento.setHours(0);
        diaVencimiento.setMinutes(0);
        diaVencimiento.setSeconds(0);

        List<Cuota> impagas = GetByImpagasPorAlumno(alumno);

        for (Cuota as : impagas) {
            if (diaVencimiento.compareTo(as.getVencimiento()) != -1) {
                debe = true;
                monto = monto + (as.getMonto() - as.getMontoPago());
                contador++;
            }
        }

        if (debe) {
            if (contador == 1) {

                mensaje = "Hola " + alumno.getNombre() + ", adeudas una cuota, con un valor de $" + monto + ".";
            } else {
                mensaje = "Hola " + alumno.getNombre() + ", adeudas " + contador + " cuotas, con un valor de $" + monto + ".";
            }
        } else {
            mensaje = "Hola " + alumno.getNombre() + "! Que tengas un buen entrenamiento";
        }

        resp.put("debe", debe);
        resp.put("mensaje", mensaje);

        return resp;
    }

}
