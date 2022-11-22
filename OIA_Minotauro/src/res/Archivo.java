package res;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import grafo.Arista;
import grafo.Grafo;

public class Archivo {

    private String nombre;

    public Archivo(String n) {
	nombre = n;
    }

    public Resolucion leerArchivo() {
	File fp = null;
	Scanner sc = null;
	Resolucion re = null;

	try {
	    fp = new File("archivos/" + nombre + ".in");
	    sc = new Scanner(fp);

	    int n = sc.nextInt();

	    Grafo G = new Grafo(n);

	    for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
		    int p = sc.nextInt();
		    if(i < j)
			G.agregarArista(i, j, p);
		}
	    }

	    re = new Resolucion(G);

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

	    pw.println(re.getMST().getAristas().size());

	    for(Arista ar : re.getMST().getAristas())
		pw.println(ar);

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

    public void generarFatiga() {
	FileWriter fw = null;
	PrintWriter pw = null;

	int n = 1000;
	int pMax = 100000000;

	try {
	    fw = new FileWriter("archivos/" + nombre + ".in");
	    pw = new PrintWriter(fw);

	    pw.println(n);

	    for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
		    if(i == j)
			pw.print(0 + " ");
		    else if(j < n - 1)
			pw.print((int) (Math.random() * pMax) + " ");
		    else
			pw.print(1);
		}
		pw.print("\n");
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

}
