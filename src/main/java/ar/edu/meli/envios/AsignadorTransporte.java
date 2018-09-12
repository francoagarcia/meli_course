package ar.edu.meli.envios;

public class AsignadorTransporte implements Asignador {

    @Override
    public Transporte asignar(Envio envio) {
        Float pesoEnvio = envio.getPesoPaquetes();

        if (pesoEnvio < 5) {
            return Transporte.BICICLETA;
        } else if (pesoEnvio < 50) {
            return Transporte.AUTO;
        } else if(pesoEnvio < 150) {
            return Transporte.CAMIONETA;
        } else {
            throw new NoSePuedeAsignarTransporteException();
        }
    }
}
