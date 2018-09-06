package ar.edu.meli.playaestacionamiento;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayaEstacionamientoTest {

    @Test
    public void ingresarVehiculos(){
        Auto golPower = new Auto();
        Auto fordFiesta = new Auto();
        PlayaEstacionamiento playaEstacionamiento = new PlayaEstacionamiento(5);

        playaEstacionamiento.ingresoVehiculo(golPower);
        playaEstacionamiento.ingresoVehiculo(fordFiesta);

        assertThat( playaEstacionamiento.cantidadVehiculos() ).isEqualTo(2);
        assertThat( playaEstacionamiento.getVehiculos().get(0) ).isEqualTo(golPower);
        assertThat( playaEstacionamiento.getVehiculos().get(1) ).isEqualTo(fordFiesta);
    }

    @Test
    public void ingresar2VehiculosY1QuedaAfuera(){
        Auto golPower = new Auto();
        Auto fordFiesta = new Auto();
        Auto fiatSiena = new Auto();
        PlayaEstacionamiento playaEstacionamiento = new PlayaEstacionamiento(2);

        playaEstacionamiento.ingresoVehiculo(golPower);
        playaEstacionamiento.ingresoVehiculo(fordFiesta);
        playaEstacionamiento.ingresoVehiculo(fiatSiena);

        assertThat( playaEstacionamiento.cantidadVehiculos() ).isEqualTo(2);
        assertThat( playaEstacionamiento.getVehiculos().get(0) ).isEqualTo(golPower);
        assertThat( playaEstacionamiento.getVehiculos().get(1) ).isEqualTo(fordFiesta);
    }
}
