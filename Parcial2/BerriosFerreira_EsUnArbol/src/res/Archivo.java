package res;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import grafo.Grafo;

public class Archivo {

    private final static String DIREC = "casos_de_prueba/";

    private String nombre;

    public Archivo(String n) {
	nombre = n;
    }

    public Resolucion leerArchivo() {
	File fp = null;
	Scanner sc = null;
	Resolucion re = null;

	try {
	    fp = new File(DIREC + "entrada/" + nombre + ".in");
	    sc = new Scanner(fp);

	    int n = sc.nextInt();
	    int m = sc.nextInt();

	    Grafo G = new Grafo(n);

	    for(int i = 0; i < m; i++)
		G.agregarArista(sc.nextInt() - 1, sc.nextInt() - 1, 1);

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
	    fw = new FileWriter(DIREC + "salida/" + nombre + ".out");
	    pw = new PrintWriter(fw);

	    pw.print(re.generarOutputString());

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

	int nMax = 10000;
	int mMax = 9999;

	try {
	    fw = new FileWriter(DIREC + "entrada/" + nombre + ".in");
	    pw = new PrintWriter(fw);

	    pw.println(nMax + " " + mMax);

	    for(int i = 1; i <= mMax; i++) {
		pw.println(i + " " + (i + 1));
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
