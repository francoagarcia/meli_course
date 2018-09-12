package ar.edu.meli.libreria;

public class Infantil extends Libro {

    private Integer edadDesde;
    private Integer edadHasta;

    public Infantil(String editorial, String titulo, Integer edadDesde, Integer edadHasta) {
        super(editorial, titulo);
        this.edadDesde = edadDesde;
        this.edadHasta = edadHasta;
    }
}
