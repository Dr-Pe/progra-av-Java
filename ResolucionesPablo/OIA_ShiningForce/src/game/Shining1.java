/*
 * Resolución de la consigna de la OIA "shining1" sin usar un paradigma totalmente OOP.
 */

package game;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Shining1 {
	
	private final static int MAX_PTOS_A_SANAR = 10;	// Cantidad de PS maximos que puede sanar el sanador x hechizo
	private final static int COSTE_D1 = 3;			// Coste en "magia" de sanar a d=1
	private final static int COSTE_D2= 5;			// Coste en "magia" de sanar a d=2

	public static void main(String[] args) {

		// Configuro archivo(s) de entrada para pruebas
		final String pathin = "test_files/shining1_01.in";
		
		// Resolucion
		System.out.println(procesarArchivosIn(pathin));

	}
	
	public static int procesarArchivosIn(String path) {
		File fp = null;
		Scanner sc = null;
		int r = -1;
		
		try {
			fp = new File(path);
			sc = new Scanner(fp);
			
			int n = sc.nextInt();	// n de luchadores a sanar
			int magia = sc.nextInt();
			int[] vinicial = new int[n];
			int[] vfinal = new int[n];
			int[] distancia = new int[n];
			
			for(int i=0; i<n; i++) {
				vinicial[i] = sc.nextInt();
				vfinal[i] = sc.nextInt();
				distancia[i] = sc.nextInt();
			}
			
			r = sanar(magia, vinicial, vfinal, distancia);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		return r;
	}

	public static int sanar(int magia, int[] vidaInicial, int[] vidaActual, int[] distancia) {
		// Retorna la cantidad maxima de puntos que puede sanar un sanador
		
		int ptosSanados = 0; // acumulador
		List<Integer[]> sanadovmagia = new ArrayList<Integer[]>();
		
		for(int i=0; i<vidaInicial.length; i++) {
			int sanado = Math.min(vidaInicial[i] - vidaActual[i], MAX_PTOS_A_SANAR);
			int coste = (distancia[i] == 1) ? COSTE_D1 : COSTE_D2;
			
			sanadovmagia.add(new Integer[] {sanado, coste});
		}
		// Ahora ordeno la lista de acuerdp a un ratio ptos_a_sanar / coste_en_magia
		Collections.sort(sanadovmagia, (i1, i2) -> (i1[0]/i1[1] - i2[0]/i2[0]));
		int i=0;
		while(magia > 0 && i<sanadovmagia.size()) {
			ptosSanados += sanadovmagia.get(i)[0];
			magia -= sanadovmagia.get(i)[1];
			i++;
		}
		
		return ptosSanados;
	}

}
