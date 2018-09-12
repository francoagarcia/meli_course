package ar.edu.meli.envios;

import java.util.Arrays;
import java.util.List;

public class Envio {
    private List<Paquete> paquetes;
    private Float costo;
    private String direccionEntrega;
    private Transporte transporte;

    public Envio(String direccionEntrega, Paquete... paquetes) {
        this.paquetes = Arrays.asList(paquetes);
        this.direccionEntrega = direccionEntrega;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Integer getCantidadPaquetes() {
        return this.paquetes.size();
    }

    public Float getPesoPaquetes() {
        return this.paquetes
                .stream()
                .map(Paquete::getPeso)
                .reduce(0f, (accum, next) -> accum + next);
    }
}
