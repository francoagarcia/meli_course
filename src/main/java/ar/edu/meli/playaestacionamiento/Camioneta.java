package ar.edu.meli.playaestacionamiento;

public class Camioneta extends Utilitario {

    public Camioneta(double cargaMaxima) {
        super(cargaMaxima);
    }

    public boolean estaVacia(){
        return this.cargas.isEmpty();
    }
}
