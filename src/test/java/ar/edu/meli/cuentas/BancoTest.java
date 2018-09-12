package ar.edu.meli.cuentas;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BancoTest {

    @Test
    public void crearBancolYAgregarCuentas(){
        Cliente juan = new Cliente("Juan");
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(100, juan);

        Cliente pepe = new Cliente("Pepe");
        CajaDeAhorroEspecial cajaDeAhorroEspecial = new CajaDeAhorroEspecial(-100, pepe);

        Cliente tito = new Cliente("Tito");
        List<Cliente> cotitulares = Arrays.asList(new Cliente("Pedro"), new Cliente("Jose"));
        CajaDeAhorroMultiCliente cajaDeAhorroMultiCliente = new CajaDeAhorroMultiCliente(-40, tito, cotitulares);

        List<Cuenta> cuentas = Arrays.asList(cajaDeAhorro, cajaDeAhorroEspecial, cajaDeAhorroMultiCliente);
        Banco banco = new Banco(cuentas);

        assertThat( banco.getCuentas().size() ).isEqualTo(3);

    }

    @Test
    public void obtenerCuentasNegativas(){
        Cliente juan = new Cliente("Juan");
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(100, juan);

        Cliente pepe = new Cliente("Pepe");
        CajaDeAhorroEspecial cajaDeAhorroEspecial = new CajaDeAhorroEspecial(-100, pepe);

        Cliente tito = new Cliente("Tito");
        List<Cliente> cotitulares = Arrays.asList(new Cliente("Pedro"), new Cliente("Jose"));
        CajaDeAhorroMultiCliente cajaDeAhorroMultiCliente = new CajaDeAhorroMultiCliente(-40, tito, cotitulares);

        List<Cuenta> cuentas = Arrays.asList(cajaDeAhorro, cajaDeAhorroEspecial, cajaDeAhorroMultiCliente);
        Banco banco = new Banco(cuentas);

        assertThat( banco.obtenerCuentasSaldoNegativo().size() ).isEqualTo(2);

    }
}
