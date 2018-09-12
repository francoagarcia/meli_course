package ar.edu.meli.envios;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AsignadorTransporteTest {

    @Test
    public void asignarBicicleta()
    {
        Envio envio = new Envio("", this.generarPaquetes(3, 1f, 2f, 1f));

        Asignador asignador = new AsignadorTransporte();

        assertThat(asignador.asignar(envio)).isEqualTo(Transporte.BICICLETA);
    }

    @Test
    public void asignarAuto()
    {
        Envio envio = new Envio("", this.generarPaquetes(3, 1f, 2f, 40f));

        Asignador asignador = new AsignadorTransporte();

        assertThat(asignador.asignar(envio)).isEqualTo(Transporte.AUTO);
    }

    @Test
    public void asignarCamioneta()
    {
        Envio envio = new Envio("", this.generarPaquetes(3, 100f, 2f, 1f));

        Asignador asignador = new AsignadorTransporte();

        assertThat(asignador.asignar(envio)).isEqualTo(Transporte.CAMIONETA);
    }

    @Test(expected = NoSePuedeAsignarTransporteException.class)
    public void envioDemasiadoPesado()
    {
        Envio envio = new Envio("", this.generarPaquetes(4, 150f, 2f, 1f, 10f));

        Asignador asignador = new AsignadorTransporte();
        asignador.asignar(envio);
    }

    private Paquete[] generarPaquetes(int cantidad, float... pesos){
        Paquete[] result = new Paquete[cantidad];
        for(int i = 0; i < cantidad; i++){
            result[i] = new Paquete(pesos[i]);
        }
        return result;
    }
}
