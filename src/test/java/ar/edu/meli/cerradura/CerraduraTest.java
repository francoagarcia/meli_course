package ar.edu.meli.cerradura;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CerraduraTest {

    @Test
    public void crearLaCerraduraYPuedeAbrirse(){
        Cerradura cerradura = new Cerradura(99, 3);

        assertThat( cerradura.abrir(99) ).isTrue();
    }

    @Test
    public void crearLaCerraduraYNoPuedeAbrirse(){
        Cerradura cerradura = new Cerradura(99, 3);

        assertThat( cerradura.abrir(1) ).isFalse();
    }

    @Test
    public void crearLaCerraduraAbrirseYEstaAbierta(){
        Cerradura cerradura = new Cerradura(99, 3);

        cerradura.abrir(99);
        assertThat( cerradura.estaAbierta() ).isTrue();

    }

    @Test
    public void crearLaCerraduraAbrirseYNoEstaAbierta(){
        Cerradura cerradura = new Cerradura(99, 3);

        cerradura.abrir(1);
        assertThat( cerradura.estaAbierta() ).isFalse();
    }

    @Test
    public void crearLaCerraduraYQuedaBloqueada(){
        Cerradura cerradura = new Cerradura(99, 3);

        cerradura.abrir(1);
        cerradura.abrir(1);
        cerradura.abrir(1);
        assertThat( cerradura.fueBloqueada() ).isTrue();
    }

    @Test
    public void crearLaCerraduraYNoQuedaBloqueada(){
        Cerradura cerradura = new Cerradura(99, 3);

        cerradura.abrir(1);
        cerradura.abrir(1);
        cerradura.abrir(99);
        assertThat( cerradura.fueBloqueada() ).isFalse();
    }

    @Test
    public void crearLaCerraduraVerificarAperturasExitosas(){
        Cerradura cerradura = new Cerradura(99, 3);

        cerradura.abrir(99);
        cerradura.abrir(1);
        cerradura.abrir(99);
        assertThat( cerradura.contarAperturasExitosas() ).isEqualTo(2);
    }

    @Test
    public void crearLaCerraduraVerificarAperturasFallidas(){
        Cerradura cerradura = new Cerradura(99, 3);

        cerradura.abrir(99);
        cerradura.abrir(1);
        cerradura.abrir(99);
        assertThat( cerradura.contarAperturasFallidas() ).isEqualTo(1);
    }

    @Test
    public void crearLaCerraduraYEstaCerrada(){
        Cerradura cerradura = new Cerradura(99, 3);

        cerradura.abrir(1);
        assertThat( cerradura.estaCerrada() ).isTrue();
    }

    @Test
    public void cerrarCerradura(){
        Cerradura cerradura = new Cerradura(99, 3);

        cerradura.abrir(99);
        cerradura.cerrar();

        assertThat( cerradura.estaCerrada() ).isTrue();
    }

    @Test
    public void cerrarCerraduraBloqueada(){
        Cerradura cerradura = new Cerradura(99, 3);

        cerradura.abrir(1);
        cerradura.abrir(1);
        cerradura.abrir(1);
        cerradura.cerrar();

        assertThat( cerradura.estaCerrada() ).isFalse();
        assertThat( cerradura.fueBloqueada() ).isTrue();

    }

    @Test
    public void cerrarCerraduraYNoAbrirlaBloqueada(){
        Cerradura cerradura = new Cerradura(99, 3);

        assertThat( cerradura.estaCerrada() ).isTrue();
    }

}
