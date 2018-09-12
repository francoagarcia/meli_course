package ar.edu.meli.motores;

public class Refrigerante {

    private Double porcentajeRefrigeracion;

    public Refrigerante(Double porcentajeRefrigeracion) {
        if (porcentajeRefrigeracion <= 0){
            throw new IllegalArgumentException();
        }
        this.porcentajeRefrigeracion = porcentajeRefrigeracion;
    }

    public double getPorcentajeRefrigeracion() {
        return porcentajeRefrigeracion;
    }
}
