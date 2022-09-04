package geom;

public class Mapa {

    private final int columnas;
    private final int filas;
    private Casilla[][] mapa;
    
    public Mapa(int columnas, int filas) {
	this.columnas = columnas;
	this.filas = filas;
	this.mapa = new Casilla[columnas][filas];
    }
}
