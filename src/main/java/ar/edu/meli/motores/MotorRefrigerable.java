package ar.edu.meli.motores;

public class MotorRefrigerable extends Motor implements Refrigerable {

    public MotorRefrigerable(Integer temperatura, Integer potencia) {
        super(temperatura, potencia);
    }

    @Override
    void subirPotencia() {

    }

    @Override
    void bajarPotencia() {

    }

    @Override
    public void refrigerar(Refrigerante refrigerante) {

    }
}
