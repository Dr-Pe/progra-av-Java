package grafo2;

import java.util.List;

import grafo.Vertice;

public class Grafo {
    // Grafo no-dirigido

    private int orden;
    private Vertice[] vertices;
    private Integer[][] ady;

    public Grafo(List<Vertice> vert) {
	this.orden = vert.size();
	this.vertices = vert.toArray(new Vertice[0]);
	this.ady = new Integer[orden][orden];
	for(int i = 0; i < orden; i++) {
	    for(int j = 0; j < orden; j++)
		agregarArista(i, j);
	}
    }

    private void agregarArista(int vi, int vf) {
	double dist = vertices[vi].distancia(vertices[vf]);

	if(vi == vf)
	    ady[vi][vf] = 0;
	else if(dist <= 50)
	    ady[vi][vf] = 1;
	else if(dist <= 100)
	    ady[vi][vf] = 2;
    }

    public Integer getPeso(int vi, int vf) {
	return ady[vi][vf];
    }

    public Integer[] Dijkstra(int ni) {
	boolean[] visit = new boolean[orden];
	Integer[] dist = ady[ni].clone();
	Integer[] prec = new Integer[orden];

	for(int i = 0; i < orden; i++) {
	    if(dist[i] != null && dist[i] < 2)
		prec[i] = ni;
	}

	Integer vx = verticeMasCercano(dist, visit);
	while(vx != null) {
	    visit[vx] = true;
	    for(int wx = 0; wx < orden; wx++) {
		if(!visit[wx]) {
		    if(dist[wx] == null && getPeso(vx, wx) != null) {
			if(getPeso(vx, wx) < 2) {
			    dist[wx] = dist[vx] + getPeso(vx, wx);
			    prec[wx] = vx;
			}
		    }
		    else if(dist[wx] != null && getPeso(vx, wx) != null
					    && dist[wx] > dist[vx] + getPeso(vx, wx)) {
			if(getPeso(vx, wx) < 2) {
			    dist[wx] = dist[vx] + getPeso(vx, wx);
			    prec[wx] = vx;
			}
		    }
		}
	    }
	    vx = verticeMasCercano(dist, visit);
	}

	return prec;
    }

    private Integer verticeMasCercano(Integer[] dis, boolean[] vis) {
	Integer r = null;
	for(int i = 0; i < orden; i++) {
	    if(r == null && dis[i] != null && !vis[i])
		r = i;
	}
	if(r == null)
	    return null;
	for(int i = r + 1; i < orden; i++) {
	    if(dis[i] != null && !vis[i] && dis[i] < r)
		r = i;
	}
	return r;
    }

    @Override
    public String toString() {
	String r = "";
	for(int i = 0; i < orden; i++) {
	    for(int j = 0; j < orden; j++) {
		r += getPeso(i, j) != null ? String.format("%3d", getPeso(i, j)) : "inf";
		r += " ";
	    }
	    r += "\n";
	}
	return r;
    }
}
