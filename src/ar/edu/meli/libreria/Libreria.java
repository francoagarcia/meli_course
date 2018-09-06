package ar.edu.meli.libreria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Libreria {

    private static Libreria INSTANCE;

    private List<Alquiler> alquileres = new ArrayList<>();

    private Libreria() {}

    public static Libreria getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Libreria();
        }

        return INSTANCE;
    }

    public void agregarAlquiler(Alquiler alquiler){
        this.alquileres.add(alquiler);
    }

    public Alquiler buscarAlquiler(Alquilable alquilable) throws AlquilableNotFoundException {
        Optional<Alquiler> alquilerEncontrado = alquileres.stream()
                                       .filter(q -> q.getObjetoAlquilado().equals(alquilable)  )
                                       .findFirst();

        if (!alquilerEncontrado.isPresent()){
            throw new AlquilableNotFoundException();
        }

        return alquilerEncontrado.get();

    }

    public void listarAlquileres(){
        this.alquileres.forEach( alquiler -> System.out.println(alquiler.imprimirInformacion()) );
    }
}