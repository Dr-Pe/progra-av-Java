import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {

	private String name;
	
	private Grafo g;
	private int nIni;
	private int nFin;
	private List<Integer[]> calles;

	public Archivo(String name) {
		this.name = name;
	}

	public void leerArchivo() {
		File fp = null;
		Scanner sc = null;

		try {
			fp = new File(this.name);
			sc = new Scanner(fp);

			int E = sc.nextInt();
			int NI = sc.nextInt();
			int NF = sc.nextInt();
			int C = sc.nextInt();

			this.g = new Grafo(E);
			this.nIni = NI - 1;
			this.nFin = NF - 1;
			this.calles = new ArrayList<Integer[]>();

			for (int i = 0; i < C; i++) {
				int ni = sc.nextInt() - 1;
				int nf = sc.nextInt() - 1;
				g.agregarArista(ni, nf, sc.nextInt());
				calles.add(new Integer[] { ni, nf });
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public void escribirArchivo(int d, List<Integer> callesACambiar) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(name);
			pw = new PrintWriter(fw);

			pw.println(d);
			for (Integer i : callesACambiar) {
				pw.print(i + " ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}

	public Grafo getG() {
		return g;
	}

	public int getNI() {
		return nIni;
	}

	public int getNF() {
		return nFin;
	}

	public List<Integer[]> getCalles() {
		return this.calles;
	}

}
