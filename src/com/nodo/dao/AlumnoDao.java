package com.nodo.dao;

import com.nodo.models.Alumno;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class AlumnoDao extends DataBase {

    public List<Alumno> GetList() {

        Query<Alumno> q = ds.createQuery(Alumno.class).
                field("enabled").equal(true);
        List<Alumno> alumnos = q.asList();

        return alumnos;
    }

    public Alumno GetByDni(int dni) {
        Query<Alumno> q = ds.createQuery(Alumno.class).filter("dni =", dni);

        Alumno alumno = q.get();
        return alumno;
    }

    public String Insert(Alumno alumno) {
        alumno.prePersist();
        alumno.setEnabled(true);
        Key<Alumno> id = ds.save(alumno);
        return id.getId().toString();
    }

    public Boolean Update(Alumno alumno) {

        alumno.prePersist();
        Query<Alumno> updQuery = ds.createQuery(Alumno.class).filter("id =", alumno.getId());

        UpdateOperations<Alumno> updOp = ds.createUpdateOperations(Alumno.class).
                set("nombre", alumno.getNombre()).
                set("telefono", alumno.getTelefono()).
                set("telefono_contacto", alumno.getTelefonoContacto()).
                set("ultima_modificacion", alumno.getUltimaModificacion()).
                set("clase", alumno.getClase()).
                set("turno", alumno.getTurno()).
                set("estado", alumno.getEstado()).
                set("datos_adicionales", alumno.getDatosAdicionales()).
                set("enabled", alumno.isEnabled());

        UpdateResults ur = ds.update(updQuery, updOp);
        return ur.getUpdatedExisting();

    }

}
