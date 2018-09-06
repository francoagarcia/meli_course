package ar.edu.meli.playaestacionamiento;

import java.util.ArrayList;
import java.util.List;

public class Utilitario extends Vehiculo {

    private double cargaMaxima;

    private List<Carga> cargas = new ArrayList<>();

    public Utilitario(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public double cargaRestante(){
        return this.cargaMaxima - this.cargas.stream().mapToDouble(carga -> carga.getPeso()).sum();
    }

    public double cargaActual(){
        return this.cargas.stream().mapToDouble(carga -> carga.getPeso()).sum();
    }

    public boolean estaVacia(){
        return this.cargas.isEmpty();
    }

    public void agregarCarga(Carga carga){
        this.cargas.add(carga);
    }
}
