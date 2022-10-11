package oia_mesadasDeGranito;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
	private String name;

	public Archivo(String name) {
		this.name = name;

	}

	public Mesada[] leerArchivo() {
		Scanner scan = null;
		Mesada[] mesadas = null;

		try {
			File file = new File("casosDePrueba/" + "in/" + this.name + ".in");
			scan = new Scanner(file);

			int cantMesadas = scan.nextInt();
			mesadas = new Mesada[cantMesadas];
			for (int i = 0; i < mesadas.length; i++)
				mesadas[i] = new Mesada(scan.nextInt(), scan.nextInt());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}

		return mesadas;
	}

	public void guardarArchivo(int minimoPilas) {
		FileWriter fileWriter = null;
		PrintWriter pw = null;

		try {
			fileWriter = new FileWriter("casosDePrueba/" + "out_obtenido/" + this.name + ".out");
			pw = new PrintWriter(fileWriter);
			pw.print(minimoPilas);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}