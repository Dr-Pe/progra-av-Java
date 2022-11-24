package graf;

public class Arista {

    private int ni;
    private int nf;
    private int p;

    public Arista(int ni, int p, int nf) {
	this.ni = ni;
	this.nf = nf;
	this.p = p;
    }

    public int getNi() {
	return ni;
    }

    public int getNf() {
	return nf;
    }

    public int getP() {
	return p;
    }

}
