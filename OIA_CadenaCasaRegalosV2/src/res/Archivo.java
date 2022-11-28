package res;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import grafo.Grafo;

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

			fp = new File("archivos/" + this.nombre + ".in");
			sc = new Scanner(fp);

			int N = sc.nextInt();
			Grafo g = new Grafo(N);

			for (int i = 0; i < N; i++) {
				int ni = sc.nextInt();
				int sig = sc.nextInt();
				while (sig != -1) {
					g.agregarArista(ni - 1, sig - 1);
					sig = sc.nextInt();
				}

			}

			r = new Resolucion(g);

		} catch (Exception e) {
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
			fw = new FileWriter("archivos/" + this.nombre + ".out");
			pw = new PrintWriter(fw);

			pw.print(r.getResultado());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}
