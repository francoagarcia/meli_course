package ar.edu.meli.envios;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DespachadorTest {

    @Test
    public void procesarEnvioEnBicicletaDe3KG() {
        Calculadora calculadora = mock(CalculadoraOCA.class);
        Asignador asignador = mock(AsignadorTransporte.class);

        when(calculadora.calcularCosto(any())).thenReturn(3f);
        when(asignador.asignar(any())).thenReturn(Transporte.BICICLETA);

        Despachador despachador = new Despachador(calculadora, asignador);

        Envio envio = despachador.procesarEnvio("Calle Wallaby, 42, Sidney", new Paquete(3f));

        assertThat(despachador.getEnviosRealizados()).isEqualTo(1);
        assertThat(envio.getTransporte()).isEqualTo(Transporte.BICICLETA);
    }
}
