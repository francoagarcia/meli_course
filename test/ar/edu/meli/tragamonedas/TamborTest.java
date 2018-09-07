package ar.edu.meli.tragamonedas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TamborTest {
    @Test
    public void crearTamborDeberiaEstarEnPosicionValida()
    {
        Tambor tambor = new Tambor();
        assertThat(tambor.obtenerPosicion()).isBetween(1, 8);
    }

    @Test
    public void girarTamborDeberiaIndicarPosicionValida()
    {
        Tambor tambor = new Tambor();
        tambor.girar();
        assertThat(tambor.obtenerPosicion()).isBetween(1, 8);
    }
}
