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

    @Override
    public boolean equals(Object obj) {
	if(this == obj)
	    return true;
	if(obj == null)
	    return false;
	if(getClass() != obj.getClass())
	    return false;
	Arista other = (Arista) obj;
	return peso == other.peso && vf == other.vf && vi == other.vi;
    }

}
