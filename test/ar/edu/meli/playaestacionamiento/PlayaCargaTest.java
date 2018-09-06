package ar.edu.meli.playaestacionamiento;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayaCargaTest {

    @Test
    public void ingresarVehiculos(){

        Carga carga10KG = new Carga(10);
        Carga carga5KG = new Carga(5);
        Carga carga2KG = new Carga(2);

        Camion camion1 = new Camion(15);
        Camion camion2 = new Camion(8);

        PlayaCarga playaCarga = new PlayaCarga(10);
        playaCarga.agregarCarga(carga10KG, carga5KG, carga2KG, carga10KG, carga5KG, carga2KG);

        playaCarga.ingresoVehiculo(camion1);
        playaCarga.ingresoVehiculo(camion2);

        assertThat( playaCarga.cantidadVehiculos() ).isEqualTo(2);
        assertThat( playaCarga.getVehiculos().get(0) ).isEqualTo(camion1);
        assertThat( playaCarga.getVehiculos().get(1) ).isEqualTo(camion2);
    }

    @Test
    public void ingresan2VehiculosY1QuedaAfuera(){

        Carga carga10KG = new Carga(10);
        Carga carga5KG = new Carga(5);
        Carga carga2KG = new Carga(2);

        Camion camion1 = new Camion(15);
        Camion camion2 = new Camion(8);
        Camioneta camioneta = new Camioneta(20);

        PlayaCarga playaCarga = new PlayaCarga(2);
        playaCarga.agregarCarga(carga10KG, carga5KG, carga2KG, carga10KG, carga5KG, carga2KG);

        playaCarga.ingresoVehiculo(camion1);
        playaCarga.ingresoVehiculo(camion2);
        playaCarga.ingresoVehiculo(camioneta);

        assertThat( playaCarga.cantidadVehiculos() ).isEqualTo(2);
        assertThat( playaCarga.getVehiculos().get(0) ).isEqualTo(camion1);
        assertThat( playaCarga.getVehiculos().get(1) ).isEqualTo(camion2);
    }

    @Test
    public void vehiculoIngresaSinCarga(){

        Carga carga10KG = new Carga(10);
        Carga carga5KG = new Carga(5);
        Carga carga2KG = new Carga(2);

        Camion camion1 = new Camion(15);
        Camion camion2 = new Camion(1);
        Camioneta camioneta = new Camioneta(5);

        PlayaCarga playaCarga = new PlayaCarga(5);
        playaCarga.agregarCarga(carga10KG, carga5KG, carga2KG, carga10KG, carga5KG, carga2KG);

        playaCarga.ingresoVehiculo(camion1);
        playaCarga.ingresoVehiculo(camion2);
        playaCarga.ingresoVehiculo(camioneta);

        assertThat( playaCarga.cantidadVehiculos() ).isEqualTo(3);
        assertThat( playaCarga.getVehiculos().get(0) ).isEqualTo(camion1);
        assertThat( playaCarga.getVehiculos().get(1) ).isEqualTo(camion2);
        assertThat( playaCarga.getVehiculos().get(2) ).isEqualTo(camioneta);
        assertThat( playaCarga.getVehiculos().get(1).cargaActual() ).isEqualTo(0);
    }

    @Test
    public void informarCargaDespachada(){

        Carga carga10KG = new Carga(10);
        Carga carga5KG = new Carga(5);

        Camion camion1 = new Camion(15);
        Camion camion2 = new Camion(10);

        PlayaCarga playaCarga = new PlayaCarga(5);
        playaCarga.agregarCarga(carga10KG, carga5KG);

        playaCarga.ingresoVehiculo(camion1);
        playaCarga.ingresoVehiculo(camion2);

        assertThat( playaCarga.cantidadVehiculos() ).isEqualTo(2);
        assertThat( playaCarga.getVehiculos().get(0) ).isEqualTo(camion1);
        assertThat( playaCarga.getVehiculos().get(1) ).isEqualTo(camion2);
        assertThat( playaCarga.informarCargaDespachada() ).isEqualTo(15);
    }

    @Test
    public void informarCamionetasVacias(){

        Carga carga10KG = new Carga(10);
        Carga carga5KG = new Carga(5);

        Camion camion1 = new Camion(15);
        Camioneta camioneta1 = new Camioneta(10);
        Camioneta camioneta2 = new Camioneta(10);

        PlayaCarga playaCarga = new PlayaCarga(5);
        playaCarga.agregarCarga(carga10KG, carga5KG);

        playaCarga.ingresoVehiculo(camion1);
        playaCarga.ingresoVehiculo(camioneta1);
        playaCarga.ingresoVehiculo(camioneta2);

        assertThat( playaCarga.cantidadVehiculos() ).isEqualTo(3);
        assertThat( playaCarga.getVehiculos().get(0) ).isEqualTo(camion1);
        assertThat( playaCarga.getVehiculos().get(1) ).isEqualTo(camioneta1);
        assertThat( playaCarga.getVehiculos().get(2) ).isEqualTo(camioneta2);
        assertThat( playaCarga.getVehiculos().get(2).cargaActual() ).isEqualTo(0);
    }

}
