package ar.edu.meli.envios;

public class CalculadoraOCA implements  Calculadora {
    @Override
    public Float calcularCosto(Envio envio) {
        Integer cantidadPaquetes = envio.getCantidadPaquetes();

        if (cantidadPaquetes < 5) {
            return 50f;
        } else if (cantidadPaquetes < 10) {
            return 80f;
        } else {
            return 150f;
        }
    }
}
