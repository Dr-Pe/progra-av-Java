package resolucion;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
	private String name;

	public Archivo(String name) {
		this.name = name;
	}

	public Resolucion leerArchivo() {

		File fp = null;
		Scanner sc = null;
		Resolucion r = null;

		try {
			fp = new File("Archivos/" + name + ".in");
			sc = new Scanner(fp);

			int N = sc.nextInt();
			Grafo g = new Grafo(N);

			for (int i = 0; i < N; i++) {
				sc.nextInt();
				int next = sc.nextInt();
				while (next != -1) {
					g.agregarArista(i, next - 1);
					next = sc.nextInt();
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
			fw = new FileWriter("Archivos/" + name + ".out");
			pw = new PrintWriter(fw);

			pw.println(r.getConjMax());

			for (Integer i : r.getConj()) {
				pw.print((i + 1) + " ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}
}
