package graphs;

public class Edge implements Comparable<Edge> {

    private int vi;
    private int vf;
    private int weight;

    public Edge(int vi, int vf, int weight) {
	this.vi = vi;
	this.vf = vf;
	this.weight = weight;
    }

    public int getVi() {
	return vi;
    }

    public int getVf() {
	return vf;
    }

    public int getWeight() {
	return weight;
    }

    @Override
    public int compareTo(Edge o) {
	return this.weight - o.weight;
    }

}
