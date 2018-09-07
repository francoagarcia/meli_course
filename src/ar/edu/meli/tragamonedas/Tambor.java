package ar.edu.meli.tragamonedas;

import java.util.Random;

public class Tambor {

    private Integer posicion;
    private Random r = new Random();
    private final static Integer POSICION_MIN = 1;
    private final static Integer POSICION_MAX = 8;

    public Tambor() {
        this.girar();
    }

    public void girar() {
        this.posicion = this.obtenerRandomEntre(POSICION_MIN, POSICION_MAX);
    }

    public Integer obtenerPosicion() {
        return this.posicion;
    }

    private int obtenerRandomEntre(Integer min, Integer max) {
        return this.r.nextInt((max - min) + 1) + min;
    }
}
