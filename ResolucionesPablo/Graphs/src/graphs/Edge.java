package graphs;

public class Edge implements Comparable<Edge> {

    private int vi;
    private int vf;
    private int weight;

    protected Edge(int vi, int vf, int weight) {
	this.vi = vi;
	this.vf = vf;
	this.weight = weight;
    }

    protected int getVi() {
	return vi;
    }

    protected int getVf() {
	return vf;
    }

    protected int getWeight() {
	return weight;
    }

    @Override
    public int compareTo(Edge o) {
	return this.weight - o.weight;
    }

}
