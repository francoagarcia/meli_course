package ar.edu.meli.playaestacionamiento;

import java.util.ArrayList;
import java.util.List;

public class Volquete implements Cargable {

    private double cargaMaxima;

    private List<Carga> cargas = new ArrayList<>();

    public Volquete(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public double cargaRestante(){
        return this.cargaMaxima - this.cargas.stream().mapToDouble(Carga::getPeso).sum();
    }

    public double cargaActual(){
        return this.cargas.stream().mapToDouble(carga -> carga.getPeso()).sum();
    }

    public void agregarCarga(Carga carga){
        this.cargas.add(carga);
    }

}
