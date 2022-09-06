package clases;

public class Sumo implements Comparable<Sumo> {

    private float peso;
    private float altura;
    private int dominados;

    public Sumo(float peso, float altura) {
	this.peso = peso;
	this.altura = altura;
	this.dominados = 0;
    }

    public int compareTo(Sumo otro) {
	if(this.peso == otro.peso && this.altura == otro.altura)
	    return 0;
	else if(this.peso >= otro.peso && this.altura >= otro.altura)
	    return 1;
	else if(this.peso <= otro.peso && this.altura <= otro.altura)
	    return -1;
	else
	    return 0;
    }

    public void combate(Sumo otro) {
	int cmpR = this.compareTo(otro);
	if(cmpR > 0)
	    this.dominados++;
	else if(cmpR < 0)
	    otro.dominados++;
    }

    public int getDominados() {
	return dominados;
    }

}
