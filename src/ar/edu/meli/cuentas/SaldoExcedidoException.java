package ar.edu.meli.cuentas;

public class SaldoExcedidoException extends RuntimeException {

    public SaldoExcedidoException(String msg){
        super(msg);
    }
}
