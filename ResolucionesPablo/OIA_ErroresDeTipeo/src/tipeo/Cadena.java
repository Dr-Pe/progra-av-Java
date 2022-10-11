package tipeo;

public class Cadena {

    private char[] cadena;

    public Cadena(String cad) {
	this.cadena = cad.toCharArray();
    }

    public char get(int idx) {
	return this.cadena[idx];
    }

    public Integer indice(char c, int inicio) {
	// Retorna indice de la primera aparicion de una letra en la cadena, null si no existe

	for(int i = inicio; i < this.cadena.length; i++) {
	    if(this.cadena[i] == c)
		return i;
	}
	return null;
    }

    public void intercambiar(int idxA, int idxB) {
	char aux = this.cadena[idxA];
	this.cadena[idxA] = this.cadena[idxB];
	this.cadena[idxB] = aux;
    }

    @Override
    public String toString() {
	return new String(this.cadena);
    }

}
