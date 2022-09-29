package test;

import tdas.ColaPrioritariaEnteros;
import tdas.MonticuloEnteros;

public class Main {

    public static void main(String[] args) {

	pruebaColaPrioritaria();
    }

    public static void pruebaColaPrioritaria() {
	ColaPrioritariaEnteros c = new ColaPrioritariaEnteros(10);

	c.encolar(1);
	c.encolar(15);
	c.encolar(2);
	c.encolar(7);

	int topPriority = c.desencolar(); // 15

	System.out.println("Mayor prioridad: " + topPriority);
    }

    public static void pruebaMonticulo() {
	MonticuloEnteros m = new MonticuloEnteros(10);

	m.agregar(5);
	m.agregar(7);
	m.agregar(15);
	m.agregar(14);
	m.agregar(9);
	m.agregar(18);
	m.agregar(20);
//	m.agregar(6);

	m.recorrer();

	int top = m.sacar();
	System.out.println("\nSaco el " + top + "\n");

	m.recorrer();
    }

}
