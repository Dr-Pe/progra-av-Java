package colgantes1;

import java.util.HashMap;
import java.util.Map;

public class Colgantes1 {

    public static void main(String[] args) {

	ArchivoColgantes colgantesIn = new ArchivoColgantes("test_files/colgantes.in");
	ArchivoColgantes colgantesOut = new ArchivoColgantes("test_files/colgantes.out");

	Map<Integer, Integer> cantColgantes = new HashMap<Integer, Integer>();
	int[] colgantes = colgantesIn.cargarColgantes();

	for(int colgante:colgantes) {
	    Integer cant = cantColgantes.putIfAbsent(colgante, 1); // Pone +1 a la key o
								   // devuelve lo que ya
								   // hay
	    if(cant != null)
		cantColgantes.put(colgante, cant + 1);
	}

	int pesoTotal = 0;
	int cantVarillas = 0;

	for(Map.Entry<Integer, Integer> par:cantColgantes.entrySet()) {
	    int peso = par.getKey();
	    int cantidad = par.getValue();

	    if(cantidad % 2 == 0) {
		pesoTotal += peso * cantidad;
		cantVarillas += cantidad / 2;
	    }
	}

	System.out.println(pesoTotal + " " + cantVarillas);
	colgantesOut.grabarColgantes(pesoTotal, cantVarillas);

    }

}
