package ar.edu.meli.persona;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;

public class Persona {

    private String nombre;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer obtenerEdad(Clock clock){
        return Period.between(this.fechaNacimiento, LocalDate.now(clock)).getDays();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
