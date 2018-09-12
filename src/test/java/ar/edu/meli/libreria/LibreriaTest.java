package ar.edu.meli.libreria;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LibreriaTest {

    @Test
    public void crearAlquilerYAlquilarUnLibro(){
        Novela novela = new Novela("Editorial Meli", "Success Factors", "Juan Perez", "Edicion 10");
        Alquiler alquiler = new Alquiler();

        alquiler.alquilar(novela);

        assertThat( alquiler.getObjetoAlquilado() ).isNotNull();
        assertThat( alquiler.getObjetoAlquilado().isAlquilado()  ).isTrue();
    }

}
