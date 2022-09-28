package test;

import tdas.MonticuloEnteros;

public class Main {

    public static void main(String[] args) {

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
