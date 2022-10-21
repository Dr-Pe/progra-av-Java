package ejercicio;

import java.io.File;
import java.util.Scanner;

import grafo.GrafoBosque;

public class Resolucion {

    private int cf;
    private int cm;
    private int[] clarosConDragones;
    private GrafoBosque bosque;

    public static void main(String[] args) {

	Resolucion r = new Resolucion("files/rescate.in");
	System.out.println(r.bosque);

    }

    public Resolucion(String pathIn) {
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
		clarosConDragones[i] = sc.nextInt();

	    bosque = new GrafoBosque(c);
	    for(int i = 0; i < s; i++)
		bosque.agregarSendero(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());


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

	/*
	 * Primero resolver con Dijkstra para un GrafoBosque sin los claros
	 * donde hay dragones, si es imposible entonces intentar de nuevo con un
	 * grafo que incluya esos claros
	 */



	return null;
    }

}
