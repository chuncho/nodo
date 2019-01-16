package model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

@Entity(name = "alumnos")
public class Alumno {

    @Id
    @Type(type = "objectid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private int dni;
    private String nombre;
    private String apellidos;
    private Long telefono;
    private Long telefonoContacto;
    private String idClase;
    private String idTurno;
    private String fechaCreacion;
    private String ultimaModificacion;
    private String estado;
    private Boolean enabled;

    public Alumno() {
        super();
    }

    public Alumno(String id, int dni, String nombre, String apellidos, Long telefono, Long telefonoContacto, String fechaCreacion, String ultimaModificacion, String estado, Boolean enabled) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.telefonoContacto = telefonoContacto;
        this.fechaCreacion = fechaCreacion;
        this.ultimaModificacion = ultimaModificacion;
        this.estado = estado;
        this.enabled = enabled;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Long getTelefono() {
        return telefono;
    }

    public Long getTelefonoContacto() {
        return telefonoContacto;
    }

    public String getIdClase() {
        return idClase;
    }

    public String getIdTurno() {
        return idTurno;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getUltimaModificacion() {
        return ultimaModificacion;
    }

    public String getEstado() {
        return estado;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public void setTelefonoContacto(Long telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public void setIdTurno(String idTurno) {
        this.idTurno = idTurno;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setUltimaModificacion(String ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}