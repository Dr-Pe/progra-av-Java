package reinas;

import java.util.ArrayList;
import java.util.List;

public class Reina {

    private static int cantidad = 0;

    public int id;
    private int fila;
    private int columna;
    private List<Integer> conflictos; // Ids de las otras Reinas con las que hay conflicto

    Reina(int f, int c) {
	Reina.cantidad++;
	this.id = cantidad;
	this.fila = f;
	this.columna = c;
	this.conflictos = new ArrayList<Integer>();
    }

    public int getFila() {
	return this.fila;
    }

    public int getColumna() {
	return this.columna;
    }

    public boolean addConflicto(Reina r) {
	return this.conflictos.add(r.id);
    }

    public Object[] getConflictos() {
	return this.conflictos.toArray();
    }

}
