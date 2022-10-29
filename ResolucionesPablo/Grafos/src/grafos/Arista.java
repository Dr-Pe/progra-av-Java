package grafos;

public class Arista implements Comparable<Arista> {

    private int vi;
    private int vf;
    private int peso;

    public Arista(int vIni, int vFin, int peso) {
	this.vi = vIni;
	this.vf = vFin;
	this.peso = peso;
    }

    @Override
    public int compareTo(Arista o) {
	return this.peso - o.peso;
    }

    public int getVi() {
	return this.vi;
    }

    public int getVf() {
	return this.vf;
    }

    public int getPeso() {
	return this.peso;
    }

}
