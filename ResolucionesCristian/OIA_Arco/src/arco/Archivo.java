
package arco;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
	private String name;

	public Archivo() {
		name = "default";
	}

	public Archivo(String name) {
		this.name = name;
	}

	public Tiro[] leerArchivo() {

		Tiro[] vecTiros = null;
		Scanner scanner = null;

		try {
			File file = new File("Casos_de_prueba/" + "in/" + this.name + ".in");

			scanner = new Scanner(file);

			int n = scanner.nextInt();
			vecTiros = new Tiro[n];

			for (int i = 0; i < n; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();

				vecTiros[i] = new Tiro(x, y);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return vecTiros;
	}

	public void guardarArchivo(Tiro[] tiros) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter("Casos_de_prueba/" + "out_obtenido/" + this.name + ".out");
			printerWriter = new PrintWriter(file);

			for (int i = 0; i < tiros.length; i++) {
				printerWriter.println(tiros[i].getEstado());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			printerWriter.close();
		}

	}
}
