package junit;

import java.util.ArrayList;
import java.util.List;

import grafos.Arista;

public class PruebasArista {

    public static void main(String[] args) {
	List<Arista> aristas = new ArrayList<Arista>();

	aristas.add(new Arista(0, 1, 7));
	aristas.add(new Arista(0, 2, 3));
	aristas.add(new Arista(1, 3, 2));
	aristas.add(new Arista(2, 1, 2));
	aristas.add(new Arista(2, 3, 8));

	aristas.sort(null);

	for(Arista a : aristas) {
	    System.out.println(a.getPeso() + " ");
	}
    }

}
