package ar.edu.meli.cuentas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CajaDeAhorroTest {

    @Test
    public void crearCajaAhorroYObtenerSaldo(){
        Cliente titular = new Cliente("Juan");
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(100, titular);

        assertThat( cajaDeAhorro.getSaldo() ).isEqualTo(100);
    }

    @Test
    public void extraer(){
        Cliente titular = new Cliente("Juan");
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(100, titular);

        cajaDeAhorro.extraer(50);
        assertThat( cajaDeAhorro.getSaldo() ).isEqualTo(50);
    }

    @Test(expected = SaldoExcedidoException.class)
    public void extraerConSaldoExcedido(){
        Cliente titular = new Cliente("Juan");
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(100, titular);

        cajaDeAhorro.extraer(150);
    }
}
