package ar.edu.meli.playaestacionamiento;

public interface Cargable {

    double cargaRestante();
    void agregarCarga(Carga carga);
    double cargaActual();
}
