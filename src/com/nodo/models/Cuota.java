package com.nodo.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity("cuotas")
public class Cuota {

    public Cuota(){super();}

    @Id
    private ObjectId id;

    @Reference(idOnly = true)
    private Alumno alumno;

    private Float monto;

    @Property("monto_pago")
    private Float montoPago;

    private String vencimiento;

    @Property("fecha_pago")
    private String fechaPago;

    private Boolean enabled;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Float getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Float montoPago) {
        this.montoPago = montoPago;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
