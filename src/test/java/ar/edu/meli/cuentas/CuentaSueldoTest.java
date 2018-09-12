package ar.edu.meli.cuentas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CuentaSueldoTest {

    @Test
    public void crearCuentaSueldoYObtenerSaldo(){
        Cliente titular = new Cliente("Juan");
        CuentaSueldo cuentaSueldo = new CuentaSueldo(100, titular);

        assertThat( cuentaSueldo.getSaldo() ).isEqualTo(100);
    }

    @Test
    public void extraer(){
        Cliente titular = new Cliente("Juan");
        CuentaSueldo cuentaSueldo = new CuentaSueldo(100, titular);

        cuentaSueldo.extraer(50);
        assertThat( cuentaSueldo.getSaldo() ).isEqualTo(50);

        cuentaSueldo.extraer(1);
        cuentaSueldo.extraer(2);
        cuentaSueldo.extraer(3);
        cuentaSueldo.extraer(4);
        cuentaSueldo.extraer(5);
        assertThat( cuentaSueldo.getSaldo() ).isEqualTo(20);
    }

    @Test(expected = SaldoExcedidoException.class)
    public void extraerSinSaldo5taVez(){
        Cliente titular = new Cliente("Juan");
        CuentaSueldo cuentaSueldo = new CuentaSueldo(100, titular);

        cuentaSueldo.extraer(50);
        assertThat( cuentaSueldo.getSaldo() ).isEqualTo(50);

        cuentaSueldo.extraer(10);
        cuentaSueldo.extraer(10);
        cuentaSueldo.extraer(10);
        cuentaSueldo.extraer(10);
        cuentaSueldo.extraer(5);
    }

    @Test(expected = SaldoExcedidoException.class)
    public void extraerMasDelSaldoDisponible(){
        Cliente titular = new Cliente("Juan");
        CuentaSueldo cuentaSueldo = new CuentaSueldo(100, titular);

        cuentaSueldo.extraer(101);
    }

    @Test
    public void depositar(){
        Cliente titular = new Cliente("Juan");
        CuentaSueldo cuentaSueldo = new CuentaSueldo(100, titular);

        cuentaSueldo.depositar(50);

        assertThat( cuentaSueldo.getSaldo() ).isEqualTo(150);
    }

}
