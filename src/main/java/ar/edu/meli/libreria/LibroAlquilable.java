package ar.edu.meli.libreria;

public interface LibroAlquilable extends Alquilable {

    Boolean getAlquilado();
    void setAlquilado(Boolean alquilado);
    String getTitulo();
    void setTitulo(String titulo);

    @Override
    default void alquilar() {
        this.setAlquilado(true);
    }

    @Override
    default void devolver() {
        this.setAlquilado(false);
    }

    @Override
    default String imprimirInformacion() {
        return "Titulo: " + this.getTitulo();
    }

    @Override
    default boolean isAlquilado(){
        return getAlquilado();
    }
}
