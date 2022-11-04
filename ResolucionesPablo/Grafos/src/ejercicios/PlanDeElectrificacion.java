package ejercicios;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import grafos.Arista;
import grafos.GrafoMST;
import grafos.GrafoNoDirigido;

public class PlanDeElectrificacion {

    /*
     * Idea:
     * 
     * Calculo MST.
     * Luego por cada central veo si eliminarla me deja desconexo el grafo. Para eso la desconecto
     * (pero guardo sus aristas por las dudas) y calculo DFS o BFS desde cualquier otra ciudad-Nodo,
     * el length de lo que DFS o BFS devuelva debe ser igual a grafo.orden - # centrales eliminadas,
     * no menos.
     * 
     */

    // In
    private List<Integer> centrales;
    private GrafoNoDirigido grafo;

    // Proc
    private GrafoMST mst;

    public static void main(String[] args) {

	PlanDeElectrificacion plan = new PlanDeElectrificacion(
				"files/electrificacion.in");

	plan.resolver();
	System.out.println(plan.resultado());

    }

    public PlanDeElectrificacion(String pathIn) {
	this.cargarArchivoIn(pathIn);
    }

    private String resultado() {
	String aristas = "";
	int ptot = 0;

	for(int n = 0; n < this.mst.getOrden(); n++) {
	    Arista[] ars = this.mst.getAristas(n).toArray(new Arista[0]);
	    for(Arista ar : ars) {
		aristas += (ar.getVi() + 1) + " " + (ar.getVf() + 1) + "\n";
		ptot += ar.getPeso();
	    }
	}

	return ptot + "\n" + aristas;
    }

    private void resolver() {
	this.mst = new GrafoMST(this.grafo).kruskal();
	int cantEliminadas = 0;
	int ciudadRaiz = 0;

	// Cualquier ciudad no-central para verificar conectividad con BFS o DFS
	while(this.centrales.contains(ciudadRaiz))
	    ciudadRaiz++;

	// Elimino centrales "sobrantes"
	for(int central : this.centrales) {
	    List<Arista> auxAristas = this.mst.getAristas(central);
	    this.mst.desconectarVertice(central);
	    if(this.mst.DFS(ciudadRaiz).length < this.mst.getOrden() - cantEliminadas
				    - 2) {
		// Agrego de nuevo esa central porque sí era importante
		for(Arista ar : auxAristas)
		    this.mst.agregarArista(ar);
	    }
	    cantEliminadas++;
	}
    }

    private void cargarArchivoIn(String pathIn) {
	File fp = null;
	Scanner sc = null;

	try {
	    fp = new File(pathIn);
	    sc = new Scanner(fp);

	    int n = sc.nextInt();
	    int k = sc.nextInt();

	    this.centrales = new ArrayList<Integer>();
	    this.grafo = new GrafoNoDirigido(n);

	    for(int i = 0; i < k; i++)
		this.centrales.add(sc.nextInt() - 1);

	    for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
		    this.grafo.agregarArista(i, j, sc.nextInt());
		}
	    }


	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}
    }

}
