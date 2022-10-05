package reinas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioOIA {

    /*
     * Opcion 1: Calcular conflictos en cada fila, columna, o diagonal. En una matriz de
     * nxn hay n filas y columnas y 2n - 3 diagonales, por lo que esta opcion tendría una
     * complejidad de f(n) = 4(n**2) - 8n -> O(n**2), con 1 <= n <= 10000.
     * 
     * Opcion 2: Calcular conflictos por cada Reina con las demas m-i reinas donde i
     * comienza en 1 y termina en m. Entonces la complejidad sería de
     * f(m) = m * m/2 -> O(m**2) con 1 <= m <= 50000. Casi igual (incluso algo menor) pero
     * con cotas mayores.
     */

    private Tablero tablero;
    private List<Reina> reinas = new ArrayList<Reina>();

    public static void main(String[] args) {

	EjercicioOIA caso1 = new EjercicioOIA();

	caso1.cargarArchivo("files/conflictos02.in");
	caso1.procesarDatos();
	caso1.grabarArchivo();

    }

    public void cargarArchivo(String path) {
	Scanner sc = null;

	try {
	    sc = new Scanner(new File(path));

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

    public void procesarDatos() {
	System.out.println(this.tablero);
	this.tablero.calcularConflictos();
    }

    public void grabarArchivo() {
	System.out.println();
	for(Reina r : this.reinas) {
	    System.out.print(r.getConflictos().length);
	    for(Object c : r.getConflictos())
		System.out.print(" " + c);
	    System.out.print("\n");
	}
    }

}
