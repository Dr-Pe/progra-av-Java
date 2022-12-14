// Parte del ejercicio 8 de la guía homonima

package geom;

public class Rectangulo extends Figura {
	
	private double ancho;
	private double alto;
	
	public Rectangulo(Punto centro, double ancho, double alto) {
		super(centro);
		this.ancho = ancho;
		this.alto = alto;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!super.equals(obj))
			return false;
		if(getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		if(other.centro != this.centro)
			return false;	// Pueden tener el mismo tamaño pero distintos centros: son diferentes
		return Double.doubleToLongBits(alto) == Double.doubleToLongBits(other.alto)
				&& Double.doubleToLongBits(ancho) == Double.doubleToLongBits(other.ancho);
	}
	
	public double area() {
		return ancho * alto;
	}

	@Override
	public String toString() {
		return "R[x=" + ancho + ", y=" + alto + ", c = " + centro + "]";
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}

}
