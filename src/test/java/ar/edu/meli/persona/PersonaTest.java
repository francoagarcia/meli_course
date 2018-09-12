package ar.edu.meli.persona;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonaTest {


    @Test
    public void edad25(){
        Persona persona = new Persona("Franco", LocalDate.of(1993, 5, 22));
//        Integer edad = persona.obtenerEdad(Clock.fixed(Instant.));
//
//        assertThat(edad).isEqualTo(25);
    }
}
