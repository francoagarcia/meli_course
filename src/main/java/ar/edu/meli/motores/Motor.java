package ar.edu.meli.motores;

public abstract class Motor {

    protected Integer temperatura;
    protected Integer potencia;

    public Motor(Integer temperatura, Integer potencia) {
        this.temperatura = temperatura;
        this.potencia = potencia;
    }

    abstract void subirPotencia();

    abstract void bajarPotencia();
}
