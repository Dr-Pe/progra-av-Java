package oia_erroresDeTipeo;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
	private String name;

	public Archivo(String name) {
		this.name = name;
	}

	public String[] leerArchivoIn() {
		File fp = null;
		Scanner scan = null;
		String[] textos = new String[2];
		try {
			fp = new File("casosDePrueba/" + "in/" + this.name + ".in");
			scan = new Scanner(fp);

			textos[0] = scan.nextLine();
			textos[1] = scan.nextLine();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
		return textos;
	}

	public void escribirArchivoOut(String path, int intercambios) {
		File fp = null;
		PrintWriter pw = null;

		try {
			fp = new File("casosDePrueba/" + "out_obtenido/" + this.name + ".out");
			pw = new PrintWriter(fp);

			pw.print(intercambios);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}

}


