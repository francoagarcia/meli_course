package ar.edu.meli.tragamonedas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TragamonedasTest {

    @Test
    public void crearTragamonedasYGana()
    {
        Tambor tambor1 = mock(Tambor.class);
        Tambor tambor2 = mock(Tambor.class);
        Tambor tambor3 = mock(Tambor.class);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);

        when(tambor1.obtenerPosicion()).thenReturn(1);
        when(tambor2.obtenerPosicion()).thenReturn(1);
        when(tambor3.obtenerPosicion()).thenReturn(1);

        tragamonedas.activar();

        assertThat(tragamonedas.entregarPremio()).isTrue();
    }

    @Test
    public void crearTragamonedasYPierde()
    {
        Tambor tambor1 = mock(Tambor.class);
        Tambor tambor2 = mock(Tambor.class);
        Tambor tambor3 = mock(Tambor.class);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);

        when(tambor1.obtenerPosicion()).thenReturn(1);
        when(tambor2.obtenerPosicion()).thenReturn(2);
        when(tambor3.obtenerPosicion()).thenReturn(3);

        tragamonedas.activar();

        assertThat(tragamonedas.entregarPremio()).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void crearTragamonedasConDistintaCantidadTamboresConfigurada()
    {
        Tambor tambor1 = new Tambor();
        new Tragamonedas(tambor1);
    }

    @Test
    public void activarTragamonedasEjecutaGirarTambor()
    {
        Tambor tambor1 = mock(Tambor.class);
        Tambor tambor2 = mock(Tambor.class);
        Tambor tambor3 = mock(Tambor.class);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);

        when(tambor1.obtenerPosicion()).thenReturn(1);
        when(tambor2.obtenerPosicion()).thenReturn(1);
        when(tambor3.obtenerPosicion()).thenReturn(1);

        tragamonedas.activar();

        verify(tambor1, times(1)).girar();
        verify(tambor2, times(1)).girar();
        verify(tambor3, times(1)).girar();
    }


    @Test
    public void siNoSeActivaTragamonedasNoDeberiaGirarTambores()
    {
        Tambor tambor1 = mock(Tambor.class);
        Tambor tambor2 = mock(Tambor.class);
        Tambor tambor3 = mock(Tambor.class);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);

        when(tambor1.obtenerPosicion()).thenReturn(1);
        when(tambor2.obtenerPosicion()).thenReturn(1);
        when(tambor3.obtenerPosicion()).thenReturn(1);

        verify(tambor1, times(0)).girar();
        verify(tambor2, times(0)).girar();
        verify(tambor3, times(0)).girar();
    }

    @Test
    public void multiplesCombinacionesGanadorasDeberianEntregarPremio()
    {
        Tambor tambor1 = mock(Tambor.class);
        Tambor tambor2 = mock(Tambor.class);
        Tambor tambor3 = mock(Tambor.class);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);

        when(tambor1.obtenerPosicion()).thenReturn(1);
        when(tambor2.obtenerPosicion()).thenReturn(1);
        when(tambor3.obtenerPosicion()).thenReturn(1);

        tragamonedas.activar();

        assertThat(tragamonedas.entregarPremio()).isTrue();

        tragamonedas.activar();

        assertThat(tragamonedas.entregarPremio()).isTrue();
    }

    @Test
    public void siCombinacionCorrectaPrimeraVezYSegundaNoDeberiaNoEntragarPemioSegunda()
    {
        Tambor tambor1 = mock(Tambor.class);
        Tambor tambor2 = mock(Tambor.class);
        Tambor tambor3 = mock(Tambor.class);

        Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);

        when(tambor1.obtenerPosicion()).thenReturn(1);
        when(tambor2.obtenerPosicion()).thenReturn(1);
        when(tambor3.obtenerPosicion()).thenReturn(1);

        tragamonedas.activar();

        assertThat(tragamonedas.entregarPremio()).isTrue();

        when(tambor1.obtenerPosicion()).thenReturn(1);
        when(tambor2.obtenerPosicion()).thenReturn(2);
        when(tambor3.obtenerPosicion()).thenReturn(4);

        tragamonedas.activar();

        assertThat(tragamonedas.entregarPremio()).isFalse();
    }
}
