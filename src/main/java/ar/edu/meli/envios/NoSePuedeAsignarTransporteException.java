package ar.edu.meli.envios;

public class NoSePuedeAsignarTransporteException extends RuntimeException {

    public NoSePuedeAsignarTransporteException() {
    }

    public NoSePuedeAsignarTransporteException(String message) {
        super(message);
    }
}
