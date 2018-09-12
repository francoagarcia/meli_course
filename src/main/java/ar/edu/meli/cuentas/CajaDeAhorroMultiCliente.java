package ar.edu.meli.cuentas;

import java.util.List;

public class CajaDeAhorroMultiCliente extends CajaDeAhorro{

    private List<Cliente> cotitulares;

    public CajaDeAhorroMultiCliente(int saldo, Cliente titular, List<Cliente> cotitulares){
        super(saldo, titular);
        this.cotitulares = cotitulares;
    }

    public List<Cliente> getCotitulares() {
        return cotitulares;
    }
}
