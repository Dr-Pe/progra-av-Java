package algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import graphs.Graph;

public class WelshPowell {

    private List<Integer> verticesSortedByDeg;
    private Map<Integer, Integer> colorPerVertex;  // <Vertex, Color>

    public WelshPowell(Graph G) {
	this.verticesSortedByDeg = verticesPerDegree(G);
	this.colorPerVertex = new HashMap<Integer, Integer>();

	colorPerVertex.put(verticesSortedByDeg.get(0), 0);
	while(colorPerVertex.size() < G.order) {

	}
    }

    private List<Integer> verticesPerDegree(Graph G) {
	Map<Integer, Integer> r = new TreeMap<Integer, Integer>();
	for(int vx = 0; vx < G.order; vx++)
	    r.put(G.neighbours(vx).size(), vx);
	return (List<Integer>) r.values();
    }

}
