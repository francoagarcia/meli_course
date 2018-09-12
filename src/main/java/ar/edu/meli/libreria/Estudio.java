package ar.edu.meli.libreria;

public class Estudio extends Libro implements LibroAlquilable {

    private Boolean alquilado;
    private String tema;

    public Estudio(String editorial, String titulo, String tema) {
        super(editorial, titulo);
        this.tema = tema;
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
