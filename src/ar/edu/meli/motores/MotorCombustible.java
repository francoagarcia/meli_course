package ar.edu.meli.motores;

public class MotorCombustible extends Motor {

    public MotorCombustible(Integer temperatura, Integer potencia) {
        super(temperatura, potencia);
    }

    @Override
    void subirPotencia() {
        this.potencia++;
        this.temperatura++;
    }

    @Override
    void bajarPotencia() {
        this.potencia--;
        this.potencia--;
    }
}
