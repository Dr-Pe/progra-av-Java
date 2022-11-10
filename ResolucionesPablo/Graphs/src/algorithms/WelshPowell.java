package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import graphs.Graph;

public class WelshPowell {

    private class Vertex implements Comparable<Vertex> {
	private int id;
	private int degree;
	private int color;

	private Vertex(int id, int deg) {
	    this.id = id;
	    this.degree = deg;
	}

	private Vertex setColor(int color) {
	    this.color = color;
	    return this;
	}

	@Override
	public int compareTo(Vertex o) {
	    return -(this.degree - o.degree); // Mayor a menor
	}
    }


    private List<Vertex> vertices; // Resultado
    private int colors;

    public WelshPowell(Graph G) {
	this.vertices = new ArrayList<Vertex>();
	this.colors = 0;

	List<Vertex> uncoloredVxs = new ArrayList<Vertex>();
	for(int vx = 0; vx < G.order; vx++)
	    uncoloredVxs.add(new Vertex(vx, G.neighbours(vx).size()));
	uncoloredVxs.sort(null);


	vertices.add(uncoloredVxs.remove(0).setColor(colors));
	while(!uncoloredVxs.isEmpty()) {
	    int vx = 0;
	    while(vx < uncoloredVxs.size()) {
		boolean coloreable = true;
		for(Vertex colored : vertices) {
		    if(G.areConnected(uncoloredVxs.get(vx).id, colored.id)
					    && colored.color == colors)
			coloreable = false;
		}
		if(coloreable)
		    vertices.add(uncoloredVxs.remove(vx).setColor(colors));
		vx++;
	    }

	    colors++;
	}
    }

    public Map<Integer, Integer> getColors() {
	Map<Integer, Integer> r = new TreeMap<Integer, Integer>();
	for(Vertex vx : vertices)
	    r.put(vx.id, vx.color);
	return r;
    }

    // TODO: Esto debería poder recibir un numero de iteraciones y calcular el mejor k en esas
    // iteraciones modificando levemente el ordenamiento de vertices
    public int chromaticNumber(int iter) {
	return this.colors;
    }

}
