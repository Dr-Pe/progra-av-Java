package res;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import grafo.Grafo;

public class Archivo {

    private final String path;

    public Archivo(String p) {
	path = p;
    }

    public Resolucion leerArchivo() {
	Resolucion r = null;
	File fp = null;
	Scanner sc = null;

	try {
	    fp = new File(path);
	    sc = new Scanner(fp);

	    int N = sc.nextInt();
	    int M = sc.nextInt();

	    Grafo g = new Grafo(N);

	    for(int i = 0; i < M; i++)
		g.agregarArista(sc.nextInt() - 1, sc.nextInt() - 1);

	    r = new Resolucion(g);

	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}


	return r;
    }

    public void escribirArchivo(Resolucion r) {
	FileWriter fw = null;
	PrintWriter pw = null;

	try {
	    fw = new FileWriter(path);
	    pw = new PrintWriter(fw);

	    pw.print(r.getInvitados());

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

    public void crearCasoDeFatiga(int n) {
	FileWriter fw = null;
	PrintWriter pw = null;

	int a = (n * (n - 1) / 2) > 100000 ? 100000 : (n * (n - 1) / 2);

	try {
	    fw = new FileWriter(path);
	    pw = new PrintWriter(fw);

	    pw.println(n + " " + a);

	    int cl = 0;
	    for(int i = 1; i <= n; i++) {
		if(cl > a)
		    break;
		for(int j = i + 1; j <= n; j++) {
		    if(cl > a)
			break;
		    pw.println(i + " " + j);
		    cl++;
		}
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
