package carrera;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Archivo {

	private String path;

	public Archivo(String path) {
		this.path = path;
	}

	public void leer(List<Corredor> cor, List<Categoria> cat, List<Integer> gan) {
		File fp = null;
		Scanner sc = null;

		try {
			fp = new File(this.path);
			sc = new Scanner(fp);

			int cantCor = sc.nextInt();
			int cantCatF = sc.nextInt();
			int cantCatM = sc.nextInt();
			int cantGanadores = sc.nextInt();

			for (int i = 0; i < cantCatF; i++)
				cat.add(new Categoria(i + 1, sc.nextInt(), sc.nextInt(), 'F'));
			for (int i = 0; i < cantCatM; i++)
				cat.add(new Categoria(i + 1, sc.nextInt(), sc.nextInt(), 'M'));
			for (int i = 0; i < cantCor; i++)
				cor.add(new Corredor(i + 1, sc.nextInt(), sc.next().charAt(0)));
			for (int i = 0; i < cantGanadores; i++)
				gan.add(sc.nextInt());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public void escribir(List<Categoria> categorias) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(this.path);
			pw = new PrintWriter(fw);

			for (Object c : categorias.toArray())
				pw.println((Categoria) c);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
