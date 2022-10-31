package ejercicios;

import java.io.File;
import java.util.Scanner;

import grafos.GrafoMST;
import grafos.GrafoNoDirigido;

public class Metro {

    /*
     * Una pequeña ciudad comenzó a construir un metro. La peculiaridad de la ciudad es que
     * se encuentra en pequeñas islas, las cuales están conectadas con túneles o puentes. El
     * proyecto debe utilizar la menor cantidad de puentes posibles. El único requisito para el
     * metro es que los habitantes de las ciudades podría tomar el metro (puede ser
     * concombinaciones) de cada isla para todas las otras.
     * 
     * Su tarea:
     * Dado un plano de la ciudad, determinar el mínimo número posible de puentes que es necesario
     * utilizar en la construcción del metro.
     * 
     * Idea:
     * Los tuneles tienen p=0 y los puentes p=1, se calcula el MST y el peso total final es la
     * cantidad de puentes estrictamente necesarios
     */

    private GrafoNoDirigido plano;

    public static void main(String[] args) {

	Metro m = new Metro("files/metro.in");

	int cantPuentes = m.resolver();

	System.out.println(cantPuentes);

    }

    public Metro(String pathIn) {
	cargarArchivoIn(pathIn);
    }

    private int resolver() {
	// Devuelve la cantidad de puentes estrictamente necesarios

	GrafoMST mst = new GrafoMST(plano);
	int pesoTotal = mst.kruskal();
	return pesoTotal;
    }

    private void cargarArchivoIn(String pathIn) {
	File fp = null;
	Scanner sc = null;

	try {
	    fp = new File(pathIn);
	    sc = new Scanner(fp);

	    this.plano = new GrafoNoDirigido(sc.nextInt());

	    int k = sc.nextInt();
	    int m = sc.nextInt();

	    for(int i = 0; i < k; i++)
		this.plano.agregarArista(sc.nextInt() - 1, sc.nextInt() - 1, 0);
	    for(int i = 0; i < m; i++)
		this.plano.agregarArista(sc.nextInt() - 1, sc.nextInt() - 1, 1);

	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}
    }

}
