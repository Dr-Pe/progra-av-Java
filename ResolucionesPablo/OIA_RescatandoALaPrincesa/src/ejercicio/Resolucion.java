package ejercicio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import grafo.GrafoBosque;

// TODO: Más casos de prueba (sin dragones, por ejemplo)

public class Resolucion {

    private String pathIn;

    private int cf;
    private int cm;
    private int[] clarosConDragones;
    private GrafoBosque bosque;

    private Integer[][] caminoPrincipe;
    private List<Integer[][]> caminosDragones;

    public static void main(String[] args) {

	Resolucion r = new Resolucion("files/rescate.in");

	String resultado = r.rescate();

	System.out.println(resultado);

    }

    public Resolucion(String pathIn) {
	this.pathIn = pathIn;
	this.leerArchivoIn();
	this.caminosDragones = new ArrayList<Integer[][]>();
    }

    private void leerArchivoIn() {
	File fp = null;
	Scanner sc = null;

	try {
	    fp = new File(pathIn);
	    sc = new Scanner(fp);

	    int c = sc.nextInt();
	    int s = sc.nextInt();
	    int d = sc.nextInt();

	    cf = sc.nextInt() - 1;
	    cm = sc.nextInt() - 1;

	    clarosConDragones = new int[d];
	    for(int i = 0; i < d; i++)
		clarosConDragones[i] = sc.nextInt() - 1;

	    bosque = new GrafoBosque(c);
	    for(int i = 0; i < s; i++) {
		// Los caminos son bidireccionales
		int ci = sc.nextInt() - 1;
		int cf = sc.nextInt() - 1;
		int l = sc.nextInt();
		bosque.agregarSendero(ci, cf, l);
		bosque.agregarSendero(cf, ci, l);
	    }


	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}
    }

    public String rescate() {
	/*
	 * Devuelve "NO HAY CAMINO" si no hay manera de llegar a la princesa,
	 * "INTERCEPTADO" si la única manera lleva a cruzarse un dragón, o una
	 * lista de claros (un camino) desde el principe a la princesa.
	 */

	calcularCaminoPrincipe();
	calcularCaminosDragones();

	if(caminoPrincipe[1][cf] == null)
	    return "NO HAY CAMINO";

	Integer[] recorridoPrincipe = calcularRecorridoOrdenadoPrincipe()
				.toArray(new Integer[0]);

	// Si algun Dragón llega al Nodo antes o a la vez que el Principe...
	for(Integer i : recorridoPrincipe) {
	    Integer mpd = menorPesoDragon(i);
	    if(mpd != null && caminoPrincipe[0][i] >= mpd)
		return "INTERCEPTADO";
	}

	return formatearRecorridoPrincipe(recorridoPrincipe);
    }

    private void calcularCaminoPrincipe() {
	// Calcula con Dijkstra los caminos del principe

	this.caminoPrincipe = bosque.dijkstra(cm);
    }

    private void calcularCaminosDragones() {
	// Calcula con Dijkstra el camino de c/Dragon

	for(int d = 0; d < clarosConDragones.length; d++) {
	    this.caminosDragones.add(bosque.dijkstra(clarosConDragones[d]));
	}
    }

    private List<Integer> calcularRecorridoOrdenadoPrincipe() {
	// Devuelve una lista de Integer con el recorrido ordenado para llegar de cm a cf

	List<Integer> r = new ArrayList<Integer>();
	Integer i = Integer.valueOf(cf);
	r.add(i);
	while(i != cm) {
	    i = caminoPrincipe[1][i];
	    r.add(i);
	}

	return r;
    }

    private Integer menorPesoDragon(Integer claro) {
	// Devuelve el menor peso (tiempo) entre todos los dragones para llegar a 'claro', null si
	// no puede llegar

	Integer menor = this.caminosDragones.get(0)[0][claro];

	for(int i = 1; i < this.clarosConDragones.length; i++) {
	    if(this.caminosDragones.get(i)[0][claro] != null
				    && this.caminosDragones.get(i)[0][claro] < menor)
		menor = this.caminosDragones.get(i)[0][claro];
	}

	return menor;
    }

    private String formatearRecorridoPrincipe(Integer[] recorrido) {
	String r = "";

	for(int i = recorrido.length - 1; i >= 0; i--)
	    r += recorrido[i] + 1 + " ";

	return r;
    }

}
