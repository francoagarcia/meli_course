package ar.edu.meli.cuentas;

import java.util.Objects;

public class Cliente {

    private String nombre;
    private boolean notificadoExtraccionDescubierto = false;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void notificar(boolean notificado){
        this.notificadoExtraccionDescubierto = notificado;
        if(this.notificadoExtraccionDescubierto){
            System.out.println("Cliente " + this.nombre + " notificado por giro en descubierto");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isNotificadoExtraccionDescubierto() {
        return notificadoExtraccionDescubierto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
