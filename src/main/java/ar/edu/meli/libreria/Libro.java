package ar.edu.meli.libreria;


public abstract class Libro {

    protected String editorial;
    protected String titulo;

    public Libro(String editorial, String titulo) {
        this.editorial = editorial;
        this.titulo = titulo;
    }
}
