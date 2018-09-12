package ar.edu.meli.playaestacionamiento;


public class PlayaEstacionamiento extends Playa<Auto> {

    public PlayaEstacionamiento(int limiteVehiculos) {
        super(limiteVehiculos);
    }

    @Override
    void ingresoVehiculo(Auto vehiculo){
        if  (limiteVehiculos > vehiculos.size()){
            vehiculos.add(vehiculo);
        }
    }

}
