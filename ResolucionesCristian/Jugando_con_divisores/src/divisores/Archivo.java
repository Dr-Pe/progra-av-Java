package divisores;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
	private String name;

	public Archivo() {

	}

	public Archivo(String name) {
		this.name = name;
	}

	public int leerArchivo() {
		int n = 0;
		File file = null;

		Scanner scanner = null;
		try {
			file = new File("Casos_de_prueba/" + "in/" + this.name + ".in");
			scanner = new Scanner(file);
			n = scanner.nextInt();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return n;
	}

	public void guardarArchivo(int agustin, int gaston) {
		FileWriter file = null;
		PrintWriter printWritter = null;
		try {
			file = new FileWriter("Casos_de_prueba/" + "out_obtenido/" + this.name + ".out");
			printWritter = new PrintWriter(file);

			printWritter.print(agustin + " " + gaston);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			printWritter.close();
		}

	}

}
