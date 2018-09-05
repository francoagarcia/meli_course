package ar.edu.meli.cuentas;

import java.util.List;
import java.util.stream.Collectors;

public class Banco {

    private List<Cuenta> cuentas;

    public Banco(List<Cuenta> cuentas){
        this.cuentas = cuentas;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public List<Cuenta> obtenerCuentasSaldoNegativo(){
        return this.cuentas.stream()
                .filter(unaCuenta -> unaCuenta.getSaldo() < 0)
                .collect(Collectors.toList());
    }
}
