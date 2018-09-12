package ar.edu.meli.envios;

public class Despachador {

    private Calculadora calculadora;
    private Asignador asignador;
    private Integer enviosRealizados = 0;

    public Despachador(Calculadora calculadora, Asignador asignador) {
        this.calculadora = calculadora;
        this.asignador = asignador;
    }

    public Envio procesarEnvio(String direccion, Paquete... paquetes) {
        Envio envio = new Envio(direccion, paquetes);

        Float costoEnvio = this.calculadora.calcularCosto(envio);
        if(enviosRealizados >= 10){
            costoEnvio += 0.10f*costoEnvio;
        }
        envio.setCosto( costoEnvio );

        Transporte transporteAsignado = this.asignador.asignar(envio);
        envio.setTransporte(transporteAsignado);

        enviosRealizados++;

        return envio;
    }

    public Integer getEnviosRealizados() {
        return enviosRealizados;
    }
}
