// Parte del ejercicio 8 de la guía homonima

package geom;

public class Circulo extends Figura {

	private double r;	// c
	
	public Circulo(Punto centro, double radio) {
		super(centro);
		this.r = radio;
	}

	@Override	// e
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!super.equals(obj))
			return false;
		if(getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		if(other.centro != this.centro)
			return false;	// Pueden tener el mismo tamaño pero distintos centros: son diferentes
		return Double.doubleToLongBits(r) == Double.doubleToLongBits(other.r);
	}
	
	@Override	// e
	public double area() {
		return Math.PI * r * r;
	}

	@Override
	public String toString() {
		return "C[r = " + r + ", c = " + centro + "]";
	}
	
}
