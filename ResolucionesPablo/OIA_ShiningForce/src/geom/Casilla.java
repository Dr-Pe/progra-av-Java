package geom;

public class Casilla {

    private int x;
    private int y;
    
    public Casilla() {
	this.x = 0;
	this.y = 0;
    }
    
    public Casilla(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public int distanciaA(Casilla otra) {
	return Math.abs(this.x - otra.x) + Math.abs(this.y - otra.y);
    }

}
