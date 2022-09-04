/*
 * Resolucion levemente más orientada a objetos para el ejercicio de la OIA "shining1".
 * Para simplificar el problema asumo que Khris está en la Casilla(0,0) y que los demas
 * luchadores se encuentran en las casillas de la forma Casilla(distancia,0).
 */

package tests;

import java.io.File;
import java.util.Scanner;

import clases.Luchador;
import clases.Sanador;
import geom.Casilla;

public class Shining1_vOOP {

    public static void main(String[] args) {
	
	// Configuro archivo(s) de entrada para pruebas
	final String pathin01 = "test_files/shining1_01.in";
	final String pathin02 = "test_files/shining1_02.in";
	
	// Resolucion y escritura en pantalla
//	System.out.println("Ptos. sanados para caso 1: " + procesarArchivosIn(pathin01));
	System.out.println("Ptos. sanados para caso 2: " + procesarArchivosIn(pathin02));
	
    }
    
    public static int procesarArchivosIn(String path) {
	File fp = null;
	Scanner sc = null;
	int r = 0;
	
	try {
		fp = new File(path);
		sc = new Scanner(fp);
		
		int n = sc.nextInt();	// n de luchadores a sanar
		int magia = sc.nextInt();
		
		Sanador khris = new Sanador(3, magia, new Casilla());
		Luchador[] equipo = new Luchador[n];
		
		for(int i=0; i<n; i++) {
		    int vi = sc.nextInt();
		    int va = sc.nextInt();
		    Casilla pos = new Casilla(sc.nextInt(), 0);
		    Luchador nuevo = new Luchador(vi, 0, pos);
		    nuevo.setVida(va);
		    equipo[i] = nuevo;
		}
		
		r = khris.sanarEquipo(equipo);
		
		
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		sc.close();
	}
	
	return r;
    }
    
}
