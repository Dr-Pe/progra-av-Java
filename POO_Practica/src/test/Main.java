package test;

import geom.Circulo;
import geom.Punto;
import geom.Rectangulo;

public class Main {

	public static void main(String[] args) {
		Rectangulo r1 = new Rectangulo(new Punto(), 1, 1);
		Circulo c1 = new Circulo(new Punto(), 1);
		
		System.out.println("Rectángulo " + r1 + " con area = " + r1.area());
		System.out.println("Círculo "+ c1 + " con area = " + c1.area());
		
	}

}
