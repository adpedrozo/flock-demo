package com.flock.demo.model.provinces;

import java.util.List;

public class ProvincesData {

    private Integer cantidad;
    private Integer inicio;
    private Object parametros;
    private List<Province> provincias;
    private Integer total;

    public ProvincesData(Integer cantidad, Integer inicio, Object parametros, List<Province> provincias, Integer total) {
        this.cantidad = cantidad;
        this.inicio = inicio;
        this.parametros = parametros;
        this.provincias = provincias;
        this.total = total;
    }

    public ProvincesData() {
    }

    @Override
    public String toString() {
        return "ProvincesData{" +
                "cantidad=" + cantidad +
                ", inicio=" + inicio +
                ", parametros=" + parametros +
                ", provincias=" + provincias +
                ", total=" + total +
                '}';
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    public Object getParametros() {
        return parametros;
    }

    public void setParametros(Object parametros) {
        this.parametros = parametros;
    }

    public List<Province> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Province> provincias) {
        this.provincias = provincias;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
