package geom;

public class Rectangulo {

    private Punto centro;
    private float x;
    private float y;

    
    public Rectangulo(Punto centro, float x, float y) {
	this.centro = centro;
	this.x = x;
	this.y = y;
    }

    public Rectangulo(float x0, float y0) {
	// Crea un rectangulo con el origen P(0,0) como esquina inferior izquierda

	this.centro = new Punto(x0 / 2, y0 / 2);
	this.x = x0;
	this.y = y0;
    }

    private float[] limites() {
	/*
	 * Devuelve un array de 4 enteros con los limites del rectangulo: [minX, maxX,
	 * minY, maxY]
	 */

	return new float[] { this.centro.getX() - (this.x / 2),
			     this.centro.getX() + (this.x / 2), 
			     this.centro.getY() - (this.y / 2),
			     this.centro.getY() + (this.y / 2) };
    }

    public boolean contieneA(Punto p) {
	float[] limites = this.limites();
	if(p.getX() > limites[0] && p.getX() < limites[1] && p.getY() > limites[2]
				&& p.getY() < limites[3])
	    return true;
	else return false;
    }

    public boolean contieneAInclusivo(Punto p) {
	float[] limites = this.limites();
	if(p.getX() >= limites[0] && p.getX() <= limites[1] && p.getY() >= limites[2]
				&& p.getY() <= limites[3])
	    return true;
	else return false;
    }

}
