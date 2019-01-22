package com.nodo.models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("movimientos")
public class Movimiento {

    public Movimiento() { super(); }

    @Id
    private String id;

    private String horario;

    private Float monto;

    @Reference("id_concepto")
    private String iiConcepto;

    @Reference("tipo_caja")
    private String tipoCaja;

    private Boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getIiConcepto() {
        return iiConcepto;
    }

    public void setIiConcepto(String iiConcepto) {
        this.iiConcepto = iiConcepto;
    }

    public String getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
