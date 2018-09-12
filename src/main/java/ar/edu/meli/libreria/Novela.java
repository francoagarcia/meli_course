package ar.edu.meli.libreria;

public class Novela extends Libro implements LibroAlquilable {

    private Boolean alquilado;
    private String autor;
    private String edicion;

    public Novela(String editorial, String titulo, String autor, String edicion) {
        super(editorial, titulo);
        this.autor = autor;
        this.edicion = edicion;
    }

    public Boolean getAlquilado() {
        return alquilado;
    }

    public void setAlquilado(Boolean alquilado) {
        this.alquilado = alquilado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
