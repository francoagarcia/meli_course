package ar.edu.meli.playaestacionamiento;

import java.util.ArrayList;
import java.util.List;

public abstract class Playa<T> {

    protected int limiteVehiculos;

    protected List<T> vehiculos = new ArrayList<>();

    public Playa(int limiteVehiculos) {
        this.limiteVehiculos = limiteVehiculos;
    }

    abstract void ingresoVehiculo(T vehiculo);

    public List<T> getVehiculos() {
        return vehiculos;
    }

    public int cantidadVehiculos() {
        return this.vehiculos.size();
    }
}
