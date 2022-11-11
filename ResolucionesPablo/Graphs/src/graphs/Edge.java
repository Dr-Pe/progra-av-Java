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

    @Override
    public boolean equals(Object obj) {
	if(this == obj)
	    return true;
	if(obj == null)
	    return false;
	if(getClass() != obj.getClass())
	    return false;
	Edge other = (Edge) obj;
	return vf == other.vf && vi == other.vi && weight == other.weight;
    }

}
