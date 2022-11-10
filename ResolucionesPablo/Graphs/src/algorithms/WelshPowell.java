package algorithms;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import graphs.Graph;

public class WelshPowell {

    private Map<Integer, Integer> colorPerVertex;  // <Vertex, Color>

    public WelshPowell(Graph G) {
		Deque<Integer> verticesSortedByDeg = sortVerticesByDegree(G);
		this.colorPerVertex = new HashMap<Integer, Integer>();

		colorPerVertex.put(verticesSortedByDeg.pop(), 0);
		while(colorPerVertex.size() < G.order) {

		}
    }

    private Deque<Integer> sortVerticesByDegree(Graph G) {
		Map<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		Deque<Integer> r = new ArrayDeque<Integer>();
		for(int vx = 0; vx < G.order; vx++)
	    	tm.put(G.neighbours(vx).size(), vx);
		// Because TreeMap orders in ascending order:
		for(Integer vx : tm.values())
			r.push(vx);
		return r;
    }

}
