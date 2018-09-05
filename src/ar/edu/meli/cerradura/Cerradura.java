package ar.edu.meli.cerradura;

public class Cerradura {

    private int claveDeApertura;
    private int cantidadDeFallosConsecutivosQueLaBloquean;
    private EstadoCerradura estadoCerradura = EstadoCerradura.CERRADA;
    private int cantidadIntentosFallidos;
    private int cantidadAperturasExitosas;
    private int cantidadAperturasFallidas;

    public Cerradura(int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean){
        this.claveDeApertura = claveDeApertura;
        this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
    }

    public boolean abrir(int clave){
        if(this.claveDeApertura != clave){
            this.cantidadIntentosFallidos++;
            this.cantidadAperturasFallidas++;
            this.estadoCerradura = EstadoCerradura.CERRADA;
            if (this.cantidadDeFallosConsecutivosQueLaBloquean <= this.cantidadIntentosFallidos){
                this.estadoCerradura = EstadoCerradura.BLOQUEADA;
            }
            return false;
        }

        this.estadoCerradura = EstadoCerradura.ABIERTA;
        this.cantidadIntentosFallidos = 0;
        this.cantidadAperturasExitosas++;

        return true;
    }

    public boolean estaAbierta(){
        return this.estadoCerradura.equals(EstadoCerradura.ABIERTA);
    }

    public boolean fueBloqueada(){
        return this.estadoCerradura.equals(EstadoCerradura.BLOQUEADA);
    }

    public int contarAperturasExitosas() {
        return this.cantidadAperturasExitosas;
    }

    public int contarAperturasFallidas(){
        return this.cantidadAperturasFallidas;
    }

    public boolean estaCerrada(){
        return this.estadoCerradura.equals(EstadoCerradura.CERRADA);
    }

    public void cerrar(){
        if(this.estadoCerradura.equals(EstadoCerradura.ABIERTA)) {
            this.estadoCerradura = EstadoCerradura.CERRADA;
            this.cantidadIntentosFallidos = 0;
        }
    }

    enum EstadoCerradura {
        CERRADA, ABIERTA, BLOQUEADA;
    }

}
