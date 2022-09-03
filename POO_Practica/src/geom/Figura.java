// Parte del ejercicio 8 de la guía homonima

package geom;

import java.util.Objects;

public abstract class Figura {
	
	protected Punto centro;	// a

	public Figura() {
		this.centro = new Punto();
	}
	
	public Figura(Punto centro) {
		this.centro = centro;
	}

	// Sirven, son útiles o deseables, estos 2 metodos de abajo en una clase abstracta???
	
	@Override	// e
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Figura other = (Figura) obj;
		return Objects.equals(centro, other.centro);
	}
	
	public double area() {
		return this.area();
	}
	
}
