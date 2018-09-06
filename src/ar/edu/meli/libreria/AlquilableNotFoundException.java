package ar.edu.meli.libreria;

public class AlquilableNotFoundException extends RuntimeException {

    public AlquilableNotFoundException() { }

    public AlquilableNotFoundException(String message) {
        super(message);
    }
}
