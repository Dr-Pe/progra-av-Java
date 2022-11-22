package res;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import grafo.Arista;
import grafo.Grafo;

public class Archivo {
	private String name;

	public Archivo(String nombre) {
		this.name = nombre;
	}

	public Resolucion leerArchivo() {
		File fp = null;
		Scanner sc = null;
		Resolucion r = null;

		try {
			fp = new File("Archivo/" + this.name + ".in");
			sc = new Scanner(fp);

			List<String> pedidos = new ArrayList<String>();
			List<Arista> pedidosDatos = new ArrayList<Arista>();
			String dato = sc.next();
			char cmp = dato.charAt(0);
			int orden = 0;

			while (cmp != 'F') {
				pedidos.add(dato);
				int ni = sc.nextInt();
				int nf = sc.nextInt();
				pedidosDatos.add(new Arista(ni - 1, nf - 1, 1));
				if (ni > orden)
					orden = ni;
				if (nf > orden)
					orden = nf;
				dato = sc.next();
				cmp = dato.charAt(0);
			}
			Grafo g = new Grafo(orden);

			r = new Resolucion(pedidos, pedidosDatos, g);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return r;
	}

	public void escribirArchito(Resolucion r) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("Archivo/" + this.name + ".out");
			pw = new PrintWriter(fw);

			for (String i : r.getRta()) {
				pw.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

}
