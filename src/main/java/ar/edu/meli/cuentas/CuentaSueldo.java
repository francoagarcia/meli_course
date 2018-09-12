package ar.edu.meli.cuentas;

public class CuentaSueldo extends Cuenta{

    private int cantidadExtracciones;

    public CuentaSueldo(int saldo, Cliente titular){
        super(saldo, titular);
    }

    @Override
    public int extraer(int cantidadAExtraer){
        int cantidadAExtraerFinal = cantidadAExtraer;
        if (this.cantidadExtracciones >= 5) {
            cantidadAExtraerFinal = cantidadAExtraer + 15;
        }

        if(this.saldo < cantidadAExtraerFinal) {
            throw new SaldoExcedidoException("Saldo excedido");
        }

        this.cantidadExtracciones++;
        this.saldo -= cantidadAExtraerFinal;
        return saldo;
    }
}
