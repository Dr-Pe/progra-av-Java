package res;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import graf.Arista;
import graf.Grafo;

public class Archivo {

    String nombre;

    public Archivo(String n) {
	nombre = n;
    }

    public Resolucion leerArchivo() {
	File fp = null;
	Scanner sc = null;
	Resolucion re = null;
	Arista[] aristas = null;
	Par[] pares;

	try {
	    fp = new File("archivos/" + nombre + ".in");
	    sc = new Scanner(fp);

	    int E = sc.nextInt();
	    aristas = new Arista[E];

	    int mayor = 0;

	    for(int i = 0; i < E; i++) {
		int ni = sc.nextInt();
		int p = sc.nextInt();
		int nf = sc.nextInt();
		aristas[i] = new Arista(ni - 1, p, nf - 1);
		if(Math.max(ni, nf) > mayor)
		    mayor = Math.max(ni, nf);
	    }

	    int C = sc.nextInt();
	    pares = new Par[C];

	    for(int i = 0; i < C; i++)
		pares[i] = new Par(sc.nextInt(), sc.nextInt());

	    Grafo G = new Grafo(mayor);

	    for(Arista ar : aristas)
		G.agregarArista(ar);

	    re = new Resolucion(G, pares);

	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}
	return re;
    }

    public void escribirArchivo(Resolucion re) {
	FileWriter fw = null;
	PrintWriter pw = null;

	try {
	    fw = new FileWriter("archivos/" + nombre + ".out");
	    pw = new PrintWriter(fw);

	    for(Integer i : re.getPosiblesFocos()) {
		pw.println(i);
	    }

	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    pw.close();
	    try {
		fw.close();
	    } catch(IOException e) {
		e.printStackTrace();
	    }
	}
    }

    public void crearCasoDeFatiga() {
	FileWriter fw = null;
	PrintWriter pw = null;

	int maxE = 30000;
	int maxC = 1000 - 1;
	int maxP = 50 - 1;
	int maxI = 100;

	try {
	    fw = new FileWriter("archivos/" + nombre + ".in");
	    pw = new PrintWriter(fw);

	    pw.println(maxE);

	    for(int i = 0; i < maxE; i++) {
		int ni = (int) (Math.random() * maxC) + 1;
		int p = (int) (Math.random() * maxP + 1);
		int nf = (int) (Math.random() * maxC) + 1;

		if(ni == nf)
		    nf++;

		pw.println(ni + " " + p + " " + nf);
	    }

	    pw.println(maxI);

	    for(int i = 0; i < maxI; i++)
		pw.println((int) (Math.random() * maxC + 1) + " "
					+ (int) (Math.random() * 20000 + 1));



	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    pw.close();
	    try {
		fw.close();
	    } catch(IOException e) {
		e.printStackTrace();
	    }
	}
    }

}
