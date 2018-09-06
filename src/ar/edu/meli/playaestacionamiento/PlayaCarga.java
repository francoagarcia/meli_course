package ar.edu.meli.playaestacionamiento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayaCarga extends Playa<Utilitario> {

    private List<Carga> cargas = new ArrayList<>();

    public PlayaCarga(int limiteVehiculos) {
        super(limiteVehiculos);
    }

    @Override
    void ingresoVehiculo(Utilitario utilitario){
        if  (limiteVehiculos > vehiculos.size()){

            if (!cargas.isEmpty()) {
                double cargaDisponible = utilitario.cargaRestante();
                Optional<Carga> cargaInsertar = this.cargas.stream().filter(carga -> carga.getPeso() < cargaDisponible).findAny();

                if (cargaInsertar.isPresent()) {
                    utilitario.agregarCarga(cargaInsertar.get());
                    this.cargas.remove(cargaInsertar.get());
                }
            }
            vehiculos.add(utilitario);
        }

    }

    void agregarCarga(Carga carga){
        this.cargas.add(carga);
    }

    void agregarCarga(Carga... cargas){
        Stream.of(cargas).forEach(this::agregarCarga);
    }

    double informarCargaDespachada(){
        return this.vehiculos.stream().mapToDouble(vehiculo -> vehiculo.cargaActual()).sum();
    }

    List<Camioneta> informarUtilitariosVacios(){
        return this.vehiculos
                .stream()
                .filter(vehiculo -> vehiculo instanceof Camioneta)
                .filter(vehiculo -> vehiculo.estaVacia())
                .map(vehiculo -> (Camioneta) vehiculo)
                .collect(Collectors.toList());
    }
}
