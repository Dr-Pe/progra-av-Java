package clases;

import geom.Casilla;
import geom.Constantes;

public class Luchador {

    protected int vidaMaxima;
    protected int vida;
    protected int magia;
    protected Casilla posicion;
    
    
    public Luchador(int vida, int magia, Casilla posicion) {
	this.vidaMaxima = vida;	// Apenas se crea un Luchador tiene toda la vida
	this.vida = vida;
	this.magia = magia;
	this.posicion = posicion;
    }
    
    public void setVida(int vida) {
	this.vida = vida;
    }
    
    public int distanciaA(Luchador otro) {
	return this.posicion.distanciaA(otro.posicion);
    }

    public int getVidaPerdida() {
	return vidaMaxima - vida;
    }
    
}
