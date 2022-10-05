package reinas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioOIA {

    /*
     * Opcion 1: Calcular conflictos en cada fila, columna, o diagonal. En una matriz de
     * nxn hay n filas y columnas y 2n - 3 diagonales, por lo que esta opcion tendría una
     * complejidad de:
     * - f(n) = 6(n^2) - 6n ---> O(n^2), con 1 <= n <= 10000
     * En el peor caso serian ~= 600x10^6 operaciones.
     * 
     * Opcion 2: Calcular conflictos por cada Reina con las demas m-i reinas donde i
     * comienza en 1 y termina en m. Entonces la complejidad sería de:
     * - f(m) = m * m/2 ---> O(m^2) con 1 <= m <= 50000
     * Casi igual (incluso algo menor) pero con cotas mayores. En el peor caso serian
     * 1250x10^6 operaciones, mucho más.
     */

    private String pathIn;
    private String pathOut;
    private Tablero tablero;
    private List<Reina> reinas = new ArrayList<Reina>();

    public static void main(String[] args) {

	EjercicioOIA caso1 = new EjercicioOIA("files/conflictos01.in",
				"files/conflictos01.out");
	EjercicioOIA caso2 = new EjercicioOIA("files/conflictos02.in",
				"files/conflictos02.out");

	// Primer .in
	caso1.cargarArchivo();
	caso1.procesarDatos();
	System.out.println("De archivo conflictos01.in:\n");
	caso1.mostrarResultados();
	caso1.grabarArchivo();

	// Segundo.in
	caso2.cargarArchivo();
	caso2.procesarDatos();
	System.out.println("\nDe archivo conflictos02.in:\n");
	caso2.mostrarResultados();
	caso2.grabarArchivo();

    }

    private EjercicioOIA(String pathIn, String pathOut) {
	this.pathIn = pathIn;
	this.pathOut = pathOut;
    }

    private void cargarArchivo() {
	Scanner sc = null;

	try {
	    sc = new Scanner(new File(pathIn));

	    int n = sc.nextInt();
	    int m = sc.nextInt();

	    this.tablero = new Tablero(n);

	    for(int i = 0; i < m; i++) {
		Reina r = new Reina(sc.nextInt(), sc.nextInt(), i + 1);
		this.tablero.add(r);
		this.reinas.add(r);
	    }

	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    sc.close();
	}

    }

    private void procesarDatos() {
	this.tablero.calcularConflictos();
    }

    private void mostrarResultados() {
	System.out.println(this.tablero);
	System.out.println();
	for(Reina r : this.reinas) {
	    System.out.print(r.getConflictos().length);
	    for(Object c : r.getConflictos())
		System.out.print(" " + c);
	    System.out.print("\n");
	}
    }

    private void grabarArchivo() {
	FileWriter fw = null;
	PrintWriter pw = null;

	try {
	    fw = new FileWriter(pathOut);
	    pw = new PrintWriter(fw);

	    for(Reina r : this.reinas) {
		pw.print(r.getConflictos().length);
		for(Object c : r.getConflictos())
		    pw.print(" " + c);
		pw.print("\n");
	    }

	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    pw.close();
	    try {
		fw.close();
	    } catch(IOException e) {
		e.printStackTrace();
	    }
	}
    }

}
