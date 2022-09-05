package test;

import transporte.Bicicleta;
import transporte.Paquete;

public class Main {

	public static void main(String[] args) {
		
		Bicicleta bici = new Bicicleta();
		Paquete paq = new Paquete(10, 1, "La Rioja");
		
		System.out.println(bici.agregarPaquete(paq));

	}

}
