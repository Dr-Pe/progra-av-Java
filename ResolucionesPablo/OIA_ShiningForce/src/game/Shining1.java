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
		final String pathin01 = "test_files/shining1_01.in";
		final String pathin02 = "test_files/shining1_02.in";
		
		// Resolucion y escritura en pantalla
		System.out.println("Ptos. sanados para caso 1: " + procesarArchivosIn(pathin01));
		System.out.println("Ptos. sanados para caso 2: " + procesarArchivosIn(pathin02));

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
		List<Integer[]> sanaciones = new ArrayList<Integer[]>();
		
		// Se llena la lista sanaciones con todas las posibles sanaciones, cuanto sanan, y cuanto cuestan
		for(int i=0; i<vidaInicial.length; i++) {
			int aSanar = vidaInicial[i] - vidaActual[i];
			
			while(aSanar > MAX_PTOS_A_SANAR) {
				int coste = (distancia[i] == 1) ? COSTE_D1 : COSTE_D2;
				
				sanaciones.add(new Integer[] {MAX_PTOS_A_SANAR, coste});
				aSanar -= MAX_PTOS_A_SANAR;
			}
			
			int sanado = Math.min(aSanar, MAX_PTOS_A_SANAR);
			int coste = (distancia[i] == 1) ? COSTE_D1 : COSTE_D2;
			sanaciones.add(new Integer[] {sanado, coste});
		}
		// Ahora se ordena la lista de acuerdo a un ratio ptos_a_sanar / coste_en_magia
		Collections.sort(sanaciones, (i1, i2) -> {
			float r1 = (float)((Integer[])i1)[0] / (float)((Integer[])i1)[1];
			float r2 = (float)((Integer[])i2)[0] / (float)((Integer[])i2)[1];
			float dif = r2 - r1;
			
			return (dif > 0) ? 1 : ((dif == 0) ? 0 : -1);
		});
		// Sanese quien pueda (mientras haya magia)
		for(int i=0; i<sanaciones.size(); i++) {
			if(magia >= sanaciones.get(i)[1]) {
				ptosSanados += sanaciones.get(i)[0];
				magia -= sanaciones.get(i)[1];
			}
			else if(magia == 0) {
				break;
			}
		}
		
		return ptosSanados;
	}

}
