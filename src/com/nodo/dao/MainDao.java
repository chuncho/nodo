package com.nodo.dao;

import com.nodo.models.Alumno;
import com.nodo.models.Profesor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MainDao {

    public MainDao(){
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NODO_DB");
        em = emf.createEntityManager();
    }

    private EntityManager em;

    public List<Alumno> GetListAlumnos(){
        return em.createQuery("select a from alumnos a", Alumno.class).getResultList();

    }

    public List<Profesor> GetListProfesores(){
        return em.createQuery("select p from profesores p", Profesor.class).getResultList();
    }
}
