package res;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import grafo.Arista;
import grafo.Grafo;

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
			fp = new File("archivos/" + this.name + ".in");
			sc = new Scanner(fp);

			int N = sc.nextInt();
			Grafo g = new Grafo(N);
			for (int i = 0; i < N; i++) {
				g.agregarArista(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
			}
			int F1 = sc.nextInt();
			int F2 = sc.nextInt();
			int F3 = sc.nextInt();

			r = new Resolucion(g, F1, F2, F3);
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
			fw = new FileWriter("archivos/" + this.name + ".out");
			pw = new PrintWriter(fw);

			if (r.getPudoF1()) {
				pw.println("SI");
				pw.println(r.getNoAristasF1().size());
				if (r.getNoAristasF1().size() > 0) {
					for (Arista ar : r.getNoAristasF1()) {
						pw.println(ar);
					}
				}
			} else
				pw.println("NO");
			if (r.getPudoF2()) {
				pw.println("SI");
				pw.println(r.getNoAristasF2().size());
				if (r.getNoAristasF2().size() > 0) {
					for (Arista ar : r.getNoAristasF2()) {
						pw.println(ar);
					}
				}
			} else
				pw.println("NO");
			if (r.getPudoF3()) {
				pw.println("SI");
				pw.println(r.getNoAristasF3().size());
				if (r.getNoAristasF3().size() > 0) {
					for (Arista ar : r.getNoAristasF3()) {
						pw.println(ar);
					}
				}
			} else
				pw.println("NO");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

	public void crearArchivoFatiga() {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("archivos/caso02_fatiga.in");
			pw = new PrintWriter(fw);
			pw.println("10000");
			int j = 0;
			for (int i = 1; i <= 10000 - j; i++) {
				for (j = i + 1; j <= 10000 - i; j++) {
					pw.println(i + " " + j + " " + (int) (Math.random() * 10000));
				}
			}
			pw.println("50 100000 100000000");
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			pw.close();
		}

	}
}
