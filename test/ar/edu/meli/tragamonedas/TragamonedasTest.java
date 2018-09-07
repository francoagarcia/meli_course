package ar.edu.meli.tragamonedas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TragamonedasTest {

    @Test
    public void crearTragamonedasYGana()
    {
        Tambor tambor1 = new TamborMock(1);
        Tambor tambor2 = new TamborMock(1);
        Tambor tambor3 = new TamborMock(1);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);

        tragamonedas.activar();

        assertThat(tragamonedas.entregarPremio()).isTrue();
    }

    @Test
    public void crearTragamonedasYPierde()
    {
        Tambor tambor1 = new TamborMock(1);
        Tambor tambor2 = new TamborMock(2);
        Tambor tambor3 = new TamborMock(3);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);

        tragamonedas.activar();

        assertThat(tragamonedas.entregarPremio()).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void crearTragamonedasConDistintaCantidadTamboresConfigurada()
    {
        Tambor tambor1 = new Tambor();
        new Tragamonedas(tambor1);
    }

}
