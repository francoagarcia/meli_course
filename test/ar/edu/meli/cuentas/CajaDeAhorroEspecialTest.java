package ar.edu.meli.cuentas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CajaDeAhorroEspecialTest {

    @Test
    public void crearCajaAhorroEspecialYObtenerSaldo(){
        Cliente titular = new Cliente("Juan");
        CajaDeAhorroEspecial cajaDeAhorroEspecial = new CajaDeAhorroEspecial(100, titular);

        assertThat( cajaDeAhorroEspecial.getSaldo() ).isEqualTo(100);
    }

    @Test
    public void extraerConSaldoPendiente(){
        Cliente titular = new Cliente("Juan");
        CajaDeAhorroEspecial cajaDeAhorroEspecial = new CajaDeAhorroEspecial(100, titular);

        cajaDeAhorroEspecial.extraer(50);
        assertThat(titular.isNotificadoExtraccionDescubierto()).isFalse();
    }

    @Test
    public void extraerConSaldoExcedido(){
        Cliente titular = new Cliente("Juan");
        CajaDeAhorroEspecial cajaDeAhorroEspecial = new CajaDeAhorroEspecial(100, titular);

        cajaDeAhorroEspecial.extraer(150);
        assertThat(titular.isNotificadoExtraccionDescubierto()).isTrue();
    }

    @Test(expected = LimiteGiroDescubiertoException.class)
    public void extraccionQueExcedeLimiteDeGiroEnDescubierto(){
        Cliente titular = new Cliente("Juan");
        CajaDeAhorroEspecial cajaDeAhorroEspecial = new CajaDeAhorroEspecial(100, titular);

        cajaDeAhorroEspecial.extraer(20000);
    }

    @Test
    public void extraerConSaldoNegativoYPositivo(){
        Cliente titular = new Cliente("Juan");
        CajaDeAhorroEspecial cajaDeAhorroEspecial = new CajaDeAhorroEspecial(100, titular);

        cajaDeAhorroEspecial.extraer(150);
        assertThat(titular.isNotificadoExtraccionDescubierto()).isTrue();

        cajaDeAhorroEspecial.depositar(100);
        assertThat(titular.isNotificadoExtraccionDescubierto()).isFalse();
    }
}
