package ar.edu.meli.cuentas;

public class CajaDeAhorroEspecial extends CajaDeAhorro{

    private static final int LIMITE_GIRO_DESCUBIERTO = 10000;

    public CajaDeAhorroEspecial(int saldo, Cliente titular) {
        super(saldo, titular);
    }

    @Override
    public int extraer(int cantidadAExtraer){
        if((this.saldo-cantidadAExtraer)<0 && Math.abs(this.saldo-cantidadAExtraer)>LIMITE_GIRO_DESCUBIERTO){
            throw new LimiteGiroDescubiertoException("Se excedió limite de giro en descubierto. Limite máximo: " + LIMITE_GIRO_DESCUBIERTO);
        }

        this.saldo -= cantidadAExtraer;

        if (this.saldo < 0) {
            this.titular.notificar(true);
        }

        return saldo;
    }

    @Override
    public int depositar(int cantidadAExtraer){
        this.saldo += cantidadAExtraer;

        if(this.saldo > 0) {
            this.titular.notificar(false);
        }

        return saldo;
    }
}
