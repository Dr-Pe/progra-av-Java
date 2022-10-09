package oia_vagonesDeTren;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//ARCHIVO
public class RegistroAnimales {
	private String name;
	
	public RegistroAnimales(String name) {
		this.name = name;
	}

	public int leerRegistro(ArrayList<Manada> animales){
		
		File pf = null;
		Scanner scan = null;
		int maxAgresividad = 0;
		
		try {
			
			pf = new File("casosDePrueba/"+"in/"+this.name+ ".in");
			scan = new Scanner(pf);
			
			int e = scan.nextInt();
			maxAgresividad = scan.nextInt();
			
			for(int i = 0; i<e; i++) {
				animales.add(new Manada(scan.next(), scan.nextInt(), scan.nextInt()));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(scan != null)
				scan.close();
		}
		
		return maxAgresividad;
	}
	
	public void escribirRegistro(Transporte transporte) {
		int minVagones = transporte.getVagones();
		int agresividadTotal = transporte.getAgresividadTotal();
		
		FileWriter archivo = null;
		PrintWriter printWr = null;
		
		try {
			archivo = new FileWriter("casosDePrueba/"+"out_obtenido/"+this.name+ ".out");
			printWr = new PrintWriter(archivo);
			
			printWr.print(minVagones +" "+ agresividadTotal);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			printWr.close();
		}
	}
}
