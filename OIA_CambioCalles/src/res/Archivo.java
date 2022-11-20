package res;

import java.io.File;
import java.util.Scanner;

import graf.Grafo;

public class Archivo {

    private String nombre;

    public Archivo(String nombre) {
	this.nombre = nombre;
    }

    public Resolucion leerArchivo() {
	File fp = null;
	Scanner sc = null;
	Resolucion r = null;

	try {
	    fp = new File("archivos/" + nombre + ".in");
	    sc = new Scanner(fp);

	    int E = sc.nextInt();
	    int ni = sc.nextInt();
	    int nf = sc.nextInt();
	    int C = sc.nextInt();

	    Grafo g = new Grafo(E);

	    for(int i = 0; i < C; i++)
		g.agregarArista(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());

	    r = new Resolucion(g, ni - 1, nf - 1);

	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}

	return r;
    }

}
