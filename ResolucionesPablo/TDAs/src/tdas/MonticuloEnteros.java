package tdas;

public class MonticuloEnteros {

    private int[] vec;
    private final int tam;
    private int cantElem;

    public MonticuloEnteros(int tam) {
	this.vec = new int[tam];
	this.tam = tam;
	this.cantElem = 0;
    }

    public boolean agregar(int elem) {
	if(this.cantElem >= this.tam)
	    return false;

	this.vec[this.cantElem + 1] = elem;
	this.cantElem++;

	int idxHijo = cantElem;
	int idxPadre = idxHijo / 2;

	while(idxPadre != 0 && vec[idxHijo] < vec[idxPadre]) {
	    intercambiar(idxHijo, idxPadre);
	    idxHijo = idxPadre;
	    idxPadre = idxHijo / 2;
	}

	return true;
    }

    public Integer sacar() {
	if(this.estaVacio())
	    return null;

	int idxPadre = 1;
	int r = this.vec[idxPadre];

	this.vec[idxPadre] = this.vec[cantElem];
	this.cantElem--;

	int idxH1 = idxPadre * 2;
	int idxH2 = (idxPadre * 2) + 1;

	while(idxH1 <= this.cantElem) {
	    int idxHMenor = idxH1;

	    if(idxH2 <= this.cantElem)
		idxHMenor = (this.vec[idxH1] < this.vec[idxH2]) ? idxH1 : idxH2;
	    if(this.vec[idxPadre] > this.vec[idxHMenor]) {
		intercambiar(idxPadre, idxHMenor);
		idxPadre = idxHMenor;
		idxH1 = idxPadre * 2;
		idxH2 = (idxPadre * 2) + 1;
	    }
	    else
		break;
	}

	return r;
    }

    public boolean estaVacio() {
	return this.cantElem == 0;
    }

    public void recorrer() {
	for(int i = 1; i <= cantElem; i++) {
	    System.out.println(this.vec[i]);
	}

    }

    private void intercambiar(int idxA, int idxB) {
	int aux = vec[idxA];
	vec[idxA] = vec[idxB];
	vec[idxB] = aux;
    }
}
