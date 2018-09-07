package ar.edu.meli.tragamonedas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Tragamonedas {

    private final static Integer CANTIDAD_TAMBORES = 3;
    private List<Tambor> tambores;

    public Tragamonedas(Tambor... tambores){
        if(!CANTIDAD_TAMBORES.equals(tambores.length) || tambores.length == 0){
            throw new IllegalArgumentException();
        }
        this.tambores = Arrays.asList(tambores);
    }

    public void activar(){
        this.tambores.forEach(Tambor::girar);
    }

    public boolean entregarPremio(){
        Tambor primerTambor =  this.tambores.stream().findFirst().get();

        Stream<Tambor> stream = this.tambores
                            .stream();
        boolean result = stream.reduce(true,
                (accum, next) -> next.obtenerPosicion().equals(primerTambor.obtenerPosicion()),
                Boolean::logicalAnd);

        return result;
    }
}
