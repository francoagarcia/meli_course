package ar.edu.meli.playaestacionamiento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayaCarga extends Playa<Cargable> {

    private List<Carga> cargas = new ArrayList<>();
    private List<Carga> cargasDespachadas = new ArrayList<>();

    public PlayaCarga(int limiteVehiculos) {
        super(limiteVehiculos);
    }

    @Override
    void ingresoVehiculo(Cargable utilitario){
        if  (limiteVehiculos > vehiculos.size()){
            insertarCargaEnVehiculo(utilitario);
            vehiculos.add(utilitario);
        }

    }

    private void insertarCargaEnVehiculo(Cargable cargable){
        if (!cargas.isEmpty()) {
            double cargaDisponible = cargable.cargaRestante();
            Optional<Carga> cargaInsertar = this.cargas.stream().filter(carga -> carga.getPeso() < cargaDisponible).findAny();

            if (cargaInsertar.isPresent()) {
                cargable.agregarCarga(cargaInsertar.get());
                this.cargas.remove(cargaInsertar.get());
                this.cargasDespachadas.add(cargaInsertar.get());
            }
        }
    }

    void agregarCarga(Carga carga){
        this.cargas.add(carga);
    }

    void agregarCarga(Carga... cargas){
        Stream.of(cargas).forEach(this::agregarCarga);
    }

    double informarCargaDespachada(){
        return this.cargasDespachadas.stream().mapToDouble(Carga::getPeso).sum();
    }

    List<Camioneta> informarCamionetasVacias(){
        return this.vehiculos
                .stream()
                .filter(vehiculo -> vehiculo instanceof Camioneta)
                .map(vehiculo -> (Camioneta) vehiculo)
                .filter(Camioneta::estaVacia)
                .collect(Collectors.toList());
    }
}
