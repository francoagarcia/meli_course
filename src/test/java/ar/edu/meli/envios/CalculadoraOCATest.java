package ar.edu.meli.envios;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculadoraOCATest {

    @Test
    public void calcularCostoEnvioDe2Paquetes()
    {
        Envio envio = new Envio("", this.generarPaquetes(2));

        Calculadora calculadora = new CalculadoraOCA();

        assertThat(calculadora.calcularCosto(envio)).isEqualTo(50f);
    }

    @Test
    public void calcularCostoEnvioDe6Paquetes()
    {
        Envio envio = new Envio("", this.generarPaquetes(6));

        Calculadora calculadora = new CalculadoraOCA();

        assertThat(calculadora.calcularCosto(envio)).isEqualTo(80f);
    }

    @Test
    public void calcularCostoEnvioDe10Paquetes()
    {
        Envio envio = new Envio("", this.generarPaquetes(10));

        Calculadora calculadora = new CalculadoraOCA();

        assertThat(calculadora.calcularCosto(envio)).isEqualTo(150f);
    }

    private Paquete[] generarPaquetes(int cantidad){
        Paquete[] result = new Paquete[cantidad];
        for(int i = 0; i < cantidad; i++){
            result[i] = new Paquete(1f);
        }
        return result;
    }
}
