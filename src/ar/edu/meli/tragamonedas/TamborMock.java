package ar.edu.meli.tragamonedas;

import java.util.Random;

public class TamborMock extends  Tambor{

    private Integer posicion;
    private Random r = new Random();
    private final static Integer POSICION_MIN = 1;
    private final static Integer POSICION_MAX = 8;

    public TamborMock(Integer posicion) {
        if (posicion < POSICION_MIN && posicion > POSICION_MAX) {
            throw new IllegalArgumentException();
        }

        this.posicion = posicion;
    }
    public TamborMock() {
        this.girar();
    }

    @Override
    public void girar() {
    }

    public void girar(Integer posicion) {
        if (posicion < POSICION_MIN && posicion > POSICION_MAX) {
            throw new IllegalArgumentException();
        }
        this.posicion = posicion;
    }

    @Override
    public Integer obtenerPosicion() {
        return this.posicion;
    }

    private int obtenerRandomEntre(Integer min, Integer max) {
        return this.r.nextInt((max - min) + 1) + min;
    }
}
