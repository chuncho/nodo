package com.nodo.model;

import com.nodo.utils.Encrypter;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.Date;

@Entity("profesores")
public class Profesor {

    private Encrypter enc = new Encrypter();

    public Profesor() {
        super();
    }

    @Id
    private ObjectId id;

    private int dni;

    private String nombre;

    private Long telefono;

    private String user;

    private String pass;

    @Property("fecha_creacion")
    private Date fechaCreacion;

    @Property("ultima_modificacion")
    private Date ultimaModificacion;

    private String ingreso;

    private String egreso;

    private boolean enabled;

    private static String secretKey = "mkkfkw";

    // metodos generales

    public void prePersist() {
        Date date = new Date();
        this.ultimaModificacion = date;
        this.fechaCreacion = date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return enc.decrypt(this.pass);
    }

    public String getUncryptedPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = enc.encrypt(pass);
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(Date ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEgreso() {
        return egreso;
    }

    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
