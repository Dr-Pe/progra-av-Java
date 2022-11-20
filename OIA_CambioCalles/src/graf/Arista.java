package graf;

public class Arista {

    private int ni;
    private int nf;
    private int p;

    public Arista(int ni, int nf, int p) {
	this.ni = ni;
	this.nf = nf;
	this.p = p;
    }

    @Override
    public boolean equals(Object obj) {
	if(this == obj)
	    return true;
	if(obj == null)
	    return false;
	if(getClass() != obj.getClass())
	    return false;
	Arista other = (Arista) obj;
	return nf == other.nf && ni == other.ni;
    }

    public int getNi() {
	return ni;
    }

    public int getNf() {
	return nf;
    }

}
