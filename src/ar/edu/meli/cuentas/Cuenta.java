package ar.edu.meli.cuentas;

public abstract class Cuenta {

    protected int saldo;
    protected Cliente titular;

    public Cuenta(int saldo, Cliente titular){
        this.saldo = saldo;
        this.titular = titular;
    }

    public int depositar(int cantidadADepositar){
        this.saldo+=cantidadADepositar;
        return this.saldo;
    }

    public int extraer(int cantidadAExtraer){
        if(this.saldo < cantidadAExtraer) {
            throw new SaldoExcedidoException("Saldo excedido");
        }
        this.saldo -= cantidadAExtraer;
        return saldo;
    }

    public int getSaldo() {
        return saldo;
    }
}
