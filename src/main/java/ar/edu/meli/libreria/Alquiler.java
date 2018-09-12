package ar.edu.meli.libreria;

import java.time.LocalDateTime;

public class Alquiler {

    private Alquilable objetoAlquilado;
    private LocalDateTime fechaAlquiler;
    private LocalDateTime fechaDevolucion;

    public void alquilar(Alquilable alquilable){
        alquilable.alquilar();
        this.objetoAlquilado = alquilable;
        this.fechaAlquiler = LocalDateTime.now();
    }

    public void devolver(){
        this.objetoAlquilado.devolver();
        this.objetoAlquilado = null;
        this.fechaDevolucion = LocalDateTime.now();
    }

    public Alquilable getObjetoAlquilado() {
        return objetoAlquilado;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String imprimirInformacion(){
        return this.objetoAlquilado.imprimirInformacion() + " - Fecha de alquiler:" + this.fechaAlquiler;
    }
}
