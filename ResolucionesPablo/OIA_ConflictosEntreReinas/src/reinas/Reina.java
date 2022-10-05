package reinas;

import java.util.HashSet;
import java.util.Set;

public class Reina {

    public int id;
    private int fila;
    private int columna;
    private Set<Integer> conflictos; // Ids de las otras Reinas con las que hay conflicto

    public Reina(int f, int c, int i) {
	this.id = i;
	this.fila = f;
	this.columna = c;
	this.conflictos = new HashSet<Integer>();
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

    public int[] getConflictos() {
	int[] ret = new int[this.conflictos.size()];
	int i = 0;
	for(Object id : this.conflictos.toArray()) {
	    ret[i] = (int) id;
	    i++;
	}
	return ret;
    }

}
