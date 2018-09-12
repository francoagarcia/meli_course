package ar.edu.meli.cuentas;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CajaDeAhorroMultiClienteTest {

    @Test
    public void crearCajaAhorroMultiClienteYObtenerSaldo(){
        Cliente titular = new Cliente("Juan");
        List<Cliente> cotitulares = Arrays.asList(new Cliente("Pepe"), new Cliente("Jose"));
        CajaDeAhorroMultiCliente cajaDeAhorroMultiCliente = new CajaDeAhorroMultiCliente(100, titular, cotitulares);

        assertThat( cajaDeAhorroMultiCliente.getSaldo() ).isEqualTo(100);
        assertThat( cajaDeAhorroMultiCliente.getCotitulares() ).isEqualTo(Arrays.asList(new Cliente("Pepe"), new Cliente("Jose")));
    }

}
