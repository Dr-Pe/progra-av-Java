package grafo;

public class Arista implements Comparable<Arista> {
	private int ni;
	private int nf;
	private int p;

	public Arista(int ni, int nf, int p) {
		this.ni = ni;
		this.nf = nf;
		this.p = p;
	}

	public int getNi() {
		return this.ni;
	}

	public int getNf() {
		return this.nf;
	}

	public int getPeso() {
		return this.p;
	}

	@Override
	public int compareTo(Arista o) {
		return this.p - o.p;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		return nf == other.nf && ni == other.ni && p == other.p;
	}

	@Override
	public String toString() {
		return (ni + 1) + " " + (nf + 1);
	}

}
